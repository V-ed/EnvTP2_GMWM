package objects;

import outils.Constantes;

public abstract class TableObject implements Constantes {
	
	protected MySQLDatabase database;
	protected String tableName;
	
	protected String idColumnName;
	protected int idObject = -1;
	
	protected String[] columnNames;
	protected Object[] values;
	
	protected TableObject(MySQLDatabase database, String tableName,
			String idColumnName, String[] columnNames, Object... values){
		
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
	
	public String[] getAllColumnNames(){
		
		String[] allColumns = new String[columnNames.length + 1];
		
		allColumns[0] = idColumnName;
		
		for(int i = 0; i < columnNames.length; i++){
			allColumns[i + 1] = columnNames[i];
		}
		
		return allColumns;
		
	}
	
	public Object[] getValues(){
		return values;
	}
	
	public void addToDatabase(){
		
		idObject = database.addToTable(tableName, columnNames, values);
		
	}
	
	public void modifyItem(Object... values){
		
		this.values = values;
		
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
