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
	
	public boolean addToTable(){
		
		boolean success = true;
		
		// TODO addToTable();
		
		return success;
		
	}
}
