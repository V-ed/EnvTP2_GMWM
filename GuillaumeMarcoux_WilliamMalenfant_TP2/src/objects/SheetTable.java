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

public abstract class SheetTable extends JTable {
	
	private ArrayList<TableObject> items;
	private String[] columns;
	
	private AbstractTableModel tableModel;
	private JScrollPane scrollableTable;
	
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	public SheetTable(ArrayList<TableObject> items, String[] columns){
		
		super();
		
		this.items = items;
		this.columns = columns;
		
		this.scrollableTable = new JScrollPane(this);
		this.tableModel = new AbstractTableModel(){
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex){
				return getValueAt(rowIndex, columnIndex);
			}
			
			@Override
			public int getColumnCount(){
				return columns.length;
			}
			
			@Override
			public int getRowCount(){
				return items.size();
			}
		};
		setModel(tableModel);
		
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		getSelectionModel().addListSelectionListener(
				new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e){
						actionOnSelect();
					}
				});
		
	}
	
	public JScrollPane getScrollableTable(){
		return scrollableTable;
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
		tableModel.fireTableRowsInserted(items.size() - 1, items.size() - 1);
		
	}
	
	public void modifyItemAt(int index, TableObject modifiedObject){
		
		items.set(index, modifiedObject);
		tableModel.fireTableRowsUpdated(index, index);
		
	}
	
	public void removeItem(int rows){
		
		items.remove(rows);
		tableModel.fireTableRowsDeleted(rows, rows);
		
	}
	
	public Object getSelectedItem(){
		return getItem(getSelectedRow());
	}
	
	public Object getItem(int index){
		return items.get(index);
	}
	
	public void setSelectedItem(int index){
		
		if(getRowCount() != 0){
			setRowSelectionInterval(index, index);
		}
		
	}
	
	public void fireTableDataChanged(){
		tableModel.fireTableDataChanged();
	}
	
}
