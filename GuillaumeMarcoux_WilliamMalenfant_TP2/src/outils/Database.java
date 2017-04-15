package outils;

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
				+ nomDatabase + "?user=root&password=" + password);
		
		objetRequetes = connection.createStatement();
		
	}
	
	public ResultSet executeQuery(String query) throws SQLException{
		
		return objetRequetes.executeQuery(query);
		
	}
	
	public String[] getAllContentOfColumn(ResultSet donnees, String columnLabel)
			throws SQLException{
		
		ArrayList<String> allContentList = new ArrayList<>();
		
		while(donnees.next()){
			
			allContentList.add(donnees.getString(columnLabel));
			
		}
		
		return allContentList.toArray(new String[allContentList.size()]);
		
	}
	
	public boolean addToTable(String tableName, String[] tableParameters,
			String[] values){
		
		boolean success = false;
		
		// TODO addToTable();
		
		if(tableParameters.length == values.length){
			
			String sqlRequest = "INSERT INTO ";
			
			sqlRequest += tableName;
			
			sqlRequest += "(";
			
			for(int i = 0; i < tableParameters.length; i++){
				sqlRequest += tableParameters[i];
				
				if(i != tableParameters.length - 1)
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
				System.out.println("Error of " + e.getClass().getSimpleName());
			}
			
		}
		
		return success;
		
	}
}
