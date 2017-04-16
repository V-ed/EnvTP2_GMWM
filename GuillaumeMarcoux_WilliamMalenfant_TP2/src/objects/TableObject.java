package objects;

import outils.Constantes;

public abstract class TableObject implements Constantes {
	
	protected Database database;
	protected String tableName;
	
	protected String idColumnName;
	protected int idObject = -1;
	
	protected String[] columnNames;
	protected String[] values;
	
	protected TableObject(Database database, String tableName,
			String idColumnName, String[] columnNames, String... values){
		
		this.database = database;
		
		this.tableName = tableName;
		this.idColumnName = idColumnName;
		
		this.columnNames = columnNames;
		this.values = values;
		
	}
	
	public String getTableName(){
		return tableName;
	}
	
	public String getIDColumnName(){
		return idColumnName;
	}
	
	public int getID(){
		return idObject;
	}
	
	public void setID(int idObject){
		this.idObject = idObject;
	}
	
	public String[] getColumnNames(){
		return columnNames;
	}
	
	public String[] getValues(){
		return values;
	}
	
	public void addToDatabase(){
		
		idObject = database.addToTable(tableName, columnNames, values);
		
	}
	
	public void modifyItem(String... values){
		if(idObject != -1){
			database.modifyObject(tableName, idColumnName, idObject,
					columnNames, values);
		}
	}
	
	public void removeFromDatabase(){
		
		if(idObject != -1){
			
			database.removeFromTable(tableName, idColumnName, idObject);
			
		}
		
	}
	
}
