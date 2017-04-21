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
			String idColumnName, String[] columnNames, boolean isFirstValueID,
			Object... values){
		
		this.database = database;
		
		this.tableName = tableName;
		this.idColumnName = idColumnName;
		
		if(isFirstValueID)
			this.idObject = (int)values[0];
		
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
	
	public String[] getColumnNamesWithoutID(){
		
		String[] columnsWithoutID = new String[columnNames.length - 1];
		
		for(int i = 0; i < columnsWithoutID.length; i++){
			columnsWithoutID[i] = columnNames[i + 1];
		}
		
		return columnsWithoutID;
	}
	
	public Object[] getValues(){
		return values;
	}
	
	public Object[] getValuesWithoutID(){
		
		Object[] values = new Object[this.values.length - 1];
		
		for(int i = 0; i < values.length; i++){
			values[i] = this.values[i + 1];
		}
		
		return values;
		
	}
	
	public void addToDatabase(){
		
		idObject = database.addToTable(tableName, getColumnNamesWithoutID(),
				getValuesWithoutID());
		
	}
	
	protected void modifyItem(Object... values){
		
		this.values = values;
		
		if(idObject != -1){
			
			database.modifyObject(tableName, idColumnName, idObject,
					getColumnNamesWithoutID(), getValuesWithoutID());
			
		}
		
	}
	
	public void removeFromDatabase(){
		
		if(idObject != -1){
			
			database.removeFromTable(tableName, idColumnName, idObject);
			
		}
		
	}
	
	@Override
	public String toString(){
		return "" + idObject;
	}
	
}
