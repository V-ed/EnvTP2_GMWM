package objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePicker {
	
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	
	private boolean hasSelected = false;
	
	public DatePicker(){
		
		model = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		
		datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter(){
			
			private String datePattern = "yyyy-MM-dd";
			private SimpleDateFormat dateFormatter = new SimpleDateFormat(
					datePattern);
			
			@Override
			public Object stringToValue(String text) throws ParseException{
				return dateFormatter.parseObject(text);
			}
			
			@Override
			public String valueToString(Object value) throws ParseException{
				if(value != null){
					Calendar cal = (Calendar)value;
					return dateFormatter.format(cal.getTime());
				}
				
				return "";
			}
			
		});
		
		datePicker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hasSelected = true;
			}
		});
		
	}
	
	public JDatePickerImpl getInterface(){
		return datePicker;
	}
	
	public int getYear(){
		return datePicker.getModel().getYear();
	}
	
	public int getMonth(){
		return datePicker.getModel().getMonth() + 1;
	}
	
	public int getDay(){
		return datePicker.getModel().getDay();
	}
	
	public String getDateAsFormattedString(){
		return getYear() + "-" + getMonth() + "-" + getDay();
	}
	
	public Date getDate(){
		return Date.valueOf(getDateAsFormattedString());
	}
	
	public void setDate(int year, int month, int day){
		
		model.setDate(year, month, day);
		model.setSelected(true);
		hasSelected = true;
		
	}
	
	public boolean isChanged(){
		return hasSelected;
	}
	
}
