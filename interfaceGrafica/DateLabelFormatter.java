package interfaceGrafica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;
/**
 * Description of DateLabelFormatter.
 * 
 * @author Gustavo Antunes Rocha
 */
public class DateLabelFormatter extends AbstractFormatter {

	private String datePattern = "dd-MM-yyyy";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	
	/**
	 * Descrição método stringToValue
	 * @param text
	 */
	@Override
	public Object stringToValue(String text) throws ParseException {
		return dateFormatter.parseObject(text);
	}
	
	/**
	 * Descrição método valueToString
	 * @param value
	 */
	@Override
	public String valueToString(Object value) throws ParseException {
		if (value != null) {
			Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());
		}

		return "";
	}

}