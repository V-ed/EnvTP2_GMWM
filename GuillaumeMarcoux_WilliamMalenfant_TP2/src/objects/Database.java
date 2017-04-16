package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	private Connection connection;
	private Statement objetRequetes;
	
	public Database(String nomDatabase, String password)
			throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/"
				+ nomDatabase, "root", password);
		
		objetRequetes = connection.createStatement();
		
	}
	
	public ResultSet executeQuery(String query){
		
		ResultSet results = null;
		
		try{
			results = objetRequetes.executeQuery(query);
		}
		catch(SQLException e){}
		
		return results;
		
	}
	
	public ResultSet getAllContentWhere(String tableName, String columnName,
			Object textToMatch) throws SQLException{
		
		String sqlRequest = "SELECT * FROM " + tableName;
		sqlRequest += " WHERE " + columnName + " = " + textToMatch;
		
		return executeQuery(sqlRequest);
		
	}
	
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
	
	public ResultSet selectEverythingFrom(String tableName){
		return executeQuery("SELECT * FROM " + tableName);
	}
	
	public ArrayList<Object[]> getAllContentofTable(String tableName){
		
		ArrayList<Object[]> table = new ArrayList<>();
		
		ResultSet queryResults = selectEverythingFrom(tableName);
		
		if(queryResults != null){
			
			try{
				
				int nCol;
				nCol = queryResults.getMetaData().getColumnCount();
				while(queryResults.next()){
					
					String[] row = new String[nCol];
					
					for(int iCol = 1; iCol <= nCol; iCol++){
						Object obj = queryResults.getObject(iCol);
						row[iCol - 1] = (obj == null) ? null : obj.toString();
					}
					
					table.add(row);
					
				}
				
			}
			catch(SQLException e){}
			
		}
		
		return table;
		
	}
	
	public int addToTable(String tableName, String[] columnNames,
			String[] values){
		
		int idCreated = -1;
		
		if(columnNames.length == values.length){
			
			String sqlRequest = "INSERT INTO ";
			
			sqlRequest += tableName;
			
			sqlRequest += "(";
			
			for(int i = 0; i < columnNames.length; i++){
				sqlRequest += columnNames[i];
				
				if(i != columnNames.length - 1)
					sqlRequest += ", ";
			}
			
			sqlRequest += ") VALUES (";
			
			for(int i = 0; i < values.length; i++){
				sqlRequest += "'" + values[i] + "'";
				
				if(i != values.length - 1)
					sqlRequest += ", ";
			}
			
			sqlRequest += ")";
			
			try{
				
				idCreated = objetRequetes.executeUpdate(sqlRequest,
						Statement.RETURN_GENERATED_KEYS);
				
				// TODO See why that doesn't work.
				
			}
			catch(SQLException e){}
			
		}
		
		return idCreated;
		
	}
	
	public boolean modifyObject(String tableName, String idColumnName,
			Object id, String[] columnNames, String[] values){
		
		boolean success = false;
		
		// TODO modifyObject()
		
		return success;
		
	}
	
	public boolean removeFromTable(String tableName, String condition){
		
		boolean success = false;
		
		String sqlRequest = "DELETE FROM " + tableName + " WHERE " + condition;
		
		try{
			
			objetRequetes.execute(sqlRequest);
			
			success = true;
			
		}
		catch(SQLException e){}
		
		return success;
		
	}
	
	public boolean removeFromTable(String tableName, String idColumnName,
			Object id){
		
		String condition = idColumnName + " = '" + id + "'";
		
		return removeFromTable(tableName, condition);
		
	}
	
}
