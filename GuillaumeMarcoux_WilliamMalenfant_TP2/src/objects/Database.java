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
	
	public ResultSet executeQuery(String query) throws SQLException{
		
		return objetRequetes.executeQuery(query);
		
	}
	
	public ResultSet getAllContentWhere(String tableName, String columnName,
			Object textToMatch) throws SQLException{
		
		String sqlRequest = "SELECT * FROM " + tableName;
		sqlRequest += " WHERE " + columnName + " = " + textToMatch;
		
		return executeQuery(sqlRequest);
		
	}
	
	public Object[] getAllContentOfColumn(ResultSet donnees, String columnName)
			throws SQLException{
		
		ArrayList<Object> allContentList = new ArrayList<>();
		
		while(donnees.next()){
			
			allContentList.add(donnees.getString(columnName));
			
		}
		
		return allContentList.toArray(new String[allContentList.size()]);
		
	}
	
	public ResultSet selectEverythingFrom(String tableName) throws SQLException{
		return executeQuery("SELECT * FROM " + tableName);
	}
	
	public ArrayList<Object[]> getAllContentofTable(String tableName)
			throws SQLException{
		
		ResultSet result = selectEverythingFrom(tableName);
		
		int nCol = result.getMetaData().getColumnCount();
		
		ArrayList<Object[]> table = new ArrayList<>();
		while(result.next()){
			
			String[] row = new String[nCol];
			for(int iCol = 1; iCol <= nCol; iCol++){
				Object obj = result.getObject(iCol);
				row[iCol - 1] = (obj == null) ? null : obj.toString();
			}
			
			table.add(row);
		}
		
		return table;
		
	}
	
	public boolean addToTable(String tableName, String[] columnNames,
			String[] values){
		
		boolean success = false;
		
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
				
				objetRequetes.execute(sqlRequest);
				
				success = true;
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		return success;
		
	}
	
	public boolean removeFromTable(String tableName, String idColumnName, int id){
		
		boolean success = false;
		
		String sqlRequest = "DELETE FROM " + tableName + " WHERE "
				+ idColumnName + " = " + id;
		
		try{
			
			objetRequetes.execute(sqlRequest);
			
			success = true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return success;
		
	}
	
}
