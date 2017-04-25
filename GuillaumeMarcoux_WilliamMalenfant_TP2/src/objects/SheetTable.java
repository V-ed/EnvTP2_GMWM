package objects;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class SheetTable extends AbstractTableModel {
	
	private ArrayList<TableObject> items;
	private String[] columns;
	
	private JTable tableItems;
	private JScrollPane scrollableTable;
	
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	public SheetTable(ArrayList<TableObject> items, String[] columns){
		
		this.items = items;
		this.columns = columns;
		
		this.tableItems = new JTable(this);
		this.scrollableTable = new JScrollPane(this.tableItems);
		
		tableItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableItems.getSelectionModel().addListSelectionListener(
				new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e){
						actionOnSelect();
					}
				});
		
	}
	
	public JTable getTable(){
		return tableItems;
	}
	
	public JScrollPane getScrollableTable(){
		return scrollableTable;
	}
	
	@Override
	public int getColumnCount(){
		return columns.length;
	}
	
	@Override
	public int getRowCount(){
		return items.size();
	}
	
	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return super.getColumnClass(columnIndex);
	}
	
	protected abstract void actionOnSelect();
	
	@Override
	public String getColumnName(int columnIndex){
		return columns[columnIndex];
	}
	
	public void addItem(TableObject newItem){
		
		items.add(newItem);
		fireTableRowsInserted(items.size() - 1, items.size() - 1);
		
	}
	
	public void modifyItemAt(int index, TableObject modifiedObject){
		
		items.set(index, modifiedObject);
		fireTableRowsUpdated(index, index);
		
	}
	
	public void removeItem(int rows){
		
		items.remove(rows);
		fireTableRowsDeleted(rows, rows);
		
	}
	
	public Object getSelectedItem(){
		return getItem(getTable().getSelectedRow());
	}
	
	public Object getItem(int index){
		return items.get(index);
	}
	
	public void setSelectedItem(int index){
		
		if(tableItems.getRowCount() != 0){
			tableItems.setRowSelectionInterval(index, index);
		}
		
	}
	
}
