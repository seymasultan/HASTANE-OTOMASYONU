package Otomasyon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

//DatePicker class
public class DateLabelFormatter extends AbstractFormatter {

	private static final long serialVersionUID = 2200059594323647178L;

	private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public Object stringToValue(String text) throws ParseException {
		return dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		return value != null ? dateFormatter.format(((Calendar) value).getTime()) : "";
	}

}