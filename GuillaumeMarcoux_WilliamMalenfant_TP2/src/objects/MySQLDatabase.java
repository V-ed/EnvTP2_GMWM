package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Object used to deal with a MySQL Databases.
 * 
 * @version 1.1
 * @author Guillaume Marcoux
 */
public class MySQLDatabase {
	
	private Connection connection;
	private Statement objetRequetes;
	
	/**
	 * Constructor for the MySQLDatabase object. This object is never closing,
	 * which means you shouldn't need to open this object for the same database
	 * twice.
	 * 
	 * @param ip
	 *            Address required to access the MySQL database. <i>Ex.
	 *            <code>localhost</code></i>.
	 * @param databaseName
	 *            Name of the database itself.
	 * @param user
	 *            The user name required to access the database.
	 * @param password
	 *            The password used to access the database.
	 * @throws ClassNotFoundException
	 *             The drivers for MySQL are not installed. <a
	 *             href="https://dev.mysql.com/downloads/connector/j/">Click
	 *             here to go to the MySQL Connector download page</a> if this
	 *             error happens and install the connector.
	 * @throws SQLException
	 *             There was an SQL error, either by entering a wrong
	 *             <code>ip</code> or a non-existant <code>databaseName</code>.
	 */
	public MySQLDatabase(String ip, String databaseName, String user,
			String password) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/"
				+ databaseName, user, password);
		
		objetRequetes = connection.createStatement();
		
	}
	
	/**
	 * @param query
	 *            Query to execute.
	 * @return A <code>ResultSet</code> object containing the results of the
	 *         query passed in parameters, <code>null</code> if there's an SQL
	 *         error.
	 */
	public ResultSet executeQuery(String query){
		
		ResultSet results = null;
		
		try{
			results = objetRequetes.executeQuery(query);
		}
		catch(SQLException e){}
		
		return results;
		
	}
	
	/**
	 * Method to return a quick <code>SELECT * FROM <i>tableName</i>;</code>
	 * 
	 * @param tableName
	 *            Name of table to select everything from.
	 * @return A <code>ResultSet</code> object containing every items from the
	 *         table passed in parameters, <code>null</code> if there's an SQL
	 *         error.
	 */
	public ResultSet selectEverythingFrom(String tableName){
		return executeQuery("SELECT * FROM " + tableName);
	}
	
	/**
	 * Method to return a quick
	 * <code>SELECT * FROM <i>tableName</i> WHERE <i>columnName</i> = <i>textToMatch</i>;</code>
	 * 
	 * @param tableName
	 *            Name of table to select everything from.
	 * @param columnName
	 *            Column name to apply the <code>WHERE</code> condition.
	 * @param textToMatch
	 *            Text to search within the column of <code>columnName</code>.
	 * @return A <code>ResultSet</code> object containing every items where
	 *         <code>textToMatch</code>, inside of the column
	 *         <code>columnName</code>, matches in the object's database,
	 *         <code>null</code> if there's an SQL error.
	 */
	public ResultSet getAllContentWhere(String tableName, String columnName,
			Object textToMatch){
		
		String sqlRequest = "SELECT * FROM " + tableName;
		sqlRequest += " WHERE " + columnName + " = \"" + textToMatch + "\"";
		
		return executeQuery(sqlRequest);
		
	}
	
	/**
	 * Method to get all item's content of a specified column.
	 * 
	 * @param donnees
	 *            <code>ResultSet</code> object containing the items to search
	 *            for.
	 * @param columnName
	 *            Column name to get the content from the <code>ResultSet</code>
	 *            object.
	 * @return An <code>Object</code> array containing all item's content of the
	 *         specified column, <code>null</code> if the <code>ResultSet</code>
	 *         is empty or if there's an SQL error.
	 */
	public Object[] getAllContentOfColumn(ResultSet donnees, String columnName){
		
		Object[] results = null;
		
		ArrayList<Object> allContentList = new ArrayList<>();
		
		try{
			
			while(donnees.next()){
				
				allContentList.add(donnees.getString(columnName));
				
			}
			
			results = allContentList.toArray(new Object[allContentList.size()]);
			
		}
		catch(SQLException e){}
		
		return results;
		
	}
	
	/**
	 * Method to get all of an item's content of a row where a condition will be
	 * applied.
	 * 
	 * @param tableName
	 *            Name of the table in which the item is located.
	 * @param columnName
	 *            Name of the column that will be used for the
	 *            <code>WHERE</code> considition.
	 * @param textToMatch
	 *            Text to search in the <code>WHERE</code> condition.
	 * @return An <code>Object</code> array containing all of a row's content.
	 *         If multiple items pass through the condition, only the first item
	 *         will be returned. Returns <code>null</code> if there's an
	 *         <code>SQLException</code> error.
	 */
	public Object[] getRowContentOfTableWhere(String tableName,
			String columnName, String textToMatch){
		
		Object[] rowContent = null;
		
		ResultSet resultSet = getAllContentWhere(tableName, columnName,
				textToMatch);
		
		try{
			
			resultSet.next();
			
			int numberOfColumns = resultSet.getMetaData().getColumnCount();
			
			rowContent = new Object[numberOfColumns];
			
			for(int iCol = 1; iCol <= numberOfColumns; iCol++){
				
				Object object = resultSet.getObject(iCol);
				
				if(object instanceof Boolean)
					object = (boolean)object ? 1 : 0;
				
				rowContent[iCol - 1] = (object == null) ? null : object;
				
			}
			
		}
		catch(SQLException e){}
		
		return rowContent;
		
	}
	
	/**
	 * Method to get everything, literally.
	 * 
	 * @param tableName
	 *            Name of the table of which to get every items inside.
	 * @return An <code>ArrayList</code> of <code>Object</code> arrays. Every
	 *         <code>Object</code> is an item in the table and everything inside
	 *         of it's array is the values of the columns. <code>null</code> if
	 *         there's an SQL error, by entering, for exemple, a table name that
	 *         doesn't exists.
	 */
	public ArrayList<Object[]> getAllContentofTable(String tableName){
		
		ArrayList<Object[]> table = null;
		
		ResultSet queryResults = selectEverythingFrom(tableName);
		
		if(queryResults != null){
			
			table = new ArrayList<>();
			
			try{
				
				int nCol = queryResults.getMetaData().getColumnCount();
				while(queryResults.next()){
					
					Object[] row = new Object[nCol];
					
					for(int iCol = 1; iCol <= nCol; iCol++){
						Object obj = queryResults.getObject(iCol);
						
						if(obj instanceof Boolean)
							obj = (boolean)obj ? 1 : 0;
						
						row[iCol - 1] = (obj == null) ? null : obj;
					}
					
					table.add(row);
					
				}
				
			}
			catch(SQLException e){
				table = null;
			}
			
		}
		
		return table;
		
	}
	
	/**
	 * <p>
	 * Method to add an item to the database.
	 * </p>
	 * <p>
	 * <b>IMPORTANT</b> : The number of columns must be the same of the number
	 * of values. Otherwise, the method will not even try to add the specified
	 * values.
	 * </p>
	 * 
	 * @param tableName
	 *            The name of the table of which the item is supposed to go
	 *            into.
	 * @param columnNames
	 *            The name of the columns of which the values will be added.
	 * @param values
	 *            The values which will be added to the columns specified.
	 * @return The id generated for the item created. If the
	 *         <i><b>important</b></i> notice haven't been followed or there is
	 *         an SQL error, the return value will be <code>-1</code>.
	 */
	public int addToTable(String tableName, String[] columnNames,
			Object[] values){
		
		int idCreated = -1;
		
		if(columnNames.length == values.length){
			
			String sqlRequest = "INSERT INTO ";
			
			sqlRequest += tableName;
			
			sqlRequest += "(";
			
			for(int i = 0; i < columnNames.length; i++){
				sqlRequest += "\"" + columnNames[i] + "\"";
				
				if(i != columnNames.length - 1)
					sqlRequest += ", ";
			}
			
			sqlRequest += ") VALUES (";
			
			for(int i = 0; i < values.length; i++){
				sqlRequest += "\"" + values[i] + "\"";
				
				if(i != values.length - 1)
					sqlRequest += ", ";
			}
			
			sqlRequest += ")";
			
			try{
				
				objetRequetes.executeUpdate(sqlRequest,
						Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs = objetRequetes.getGeneratedKeys();
				
				if(rs.next()){
					idCreated = rs.getInt(1);
				}
				
			}
			catch(SQLException e){}
			
		}
		
		return idCreated;
		
	}
	
	/**
	 * <p>
	 * Method which purpose is to modify an object inside this database.
	 * </p>
	 * <p>
	 * <b>IMPORTANT</b> : The values will be modified in the order of the
	 * columns, which means the <code>columnNames</code> and <code>values</code>
	 * ' content order is important.
	 * </p>
	 * 
	 * @param tableName
	 *            Name of the table which the object is located in.
	 * @param idColumnName
	 *            Name of the column where a condition will be applied in
	 *            conjunction with the parameter <code>id</code>.
	 * @param id
	 *            Value that will be applied in the condition <code>WHERE</code>
	 *            .
	 * @param columnNames
	 *            Columns that will be changed.
	 * @param values
	 *            Values of which will be applied.
	 * @return <code>true</code> if one or more rows have been modified
	 *         succesfully, <code>false</code> if there's an SQL error (ex.:
	 *         non-existant table name) or if no row have been modified.
	 */
	public boolean modifyObject(String tableName, String idColumnName,
			Object id, String[] columnNames, Object[] values){
		
		boolean success = false;
		
		String sqlRequest = "UPDATE " + tableName;
		
		sqlRequest += " SET ";
		
		for(int i = 0; i < columnNames.length; i++){
			
			sqlRequest += "\"" + columnNames[i] + "\" = \"" + values[i] + "\"";
			
			if(i < columnNames.length - 1){
				sqlRequest += ", ";
			}
			
		}
		
		sqlRequest += " WHERE \"" + idColumnName + "\" = \"" + id + "\"";
		
		try{
			
			int numberOfRowsAffected = objetRequetes.executeUpdate(sqlRequest);
			
			if(numberOfRowsAffected != 0)
				success = true;
			
		}
		catch(SQLException e){}
		
		return success;
		
	}
	
	/**
	 * Method to execute a quick
	 * <code>DELETE FROM <i>tableName</i> WHERE <i>condition</i>;</code>
	 * 
	 * @param tableName
	 *            Name of the table of which the deletion will affect.
	 * @param condition
	 *            SQL condition that will be executed. <i>Ex. :
	 *            <code>idItem = 4</code></i>
	 * @return <code>true</code> if one or more rows have been deleted
	 *         succesfully, <code>false</code> if there's an SQL error (ex.:
	 *         non-existant table name) or if no row have been deleted.
	 */
	public boolean removeFromTable(String tableName, String condition){
		
		boolean success = false;
		
		String sqlRequest = "DELETE FROM " + tableName + " WHERE " + condition;
		
		try{
			
			int numberOfRowsAffected = objetRequetes.executeUpdate(sqlRequest);
			
			if(numberOfRowsAffected != 0)
				success = true;
			
		}
		catch(SQLException e){}
		
		return success;
		
	}
	
	/**
	 * Method that executes {@link #removeFromTable(String, String)} but with a
	 * pre-made condition using <code>idColumnName</code> and <code>id</code>.
	 * 
	 * @param tableName
	 *            Name of the table of which the deletion will affect.
	 * @param idColumnName
	 *            Name of the column which the condition will look upon, usually
	 *            the column with a unique ID.
	 * @param id
	 *            Value that will be applied in the condition.
	 * @return <code>true</code> if one or more rows have been deleted
	 *         succesfully, <code>false</code> if there's an SQL error (ex.:
	 *         non-existant table name) or if no row have been deleted.
	 */
	public boolean removeFromTable(String tableName, String idColumnName,
			Object id){
		
		String condition = "\"" + idColumnName + "\" = \"" + id + "\"";
		
		return removeFromTable(tableName, condition);
		
	}
	
}
