package br.com.msystem.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateToTimestampConverter")
public class DateToTimestampConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Date d;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(value);
		} catch (ParseException e) {
			d = new Date();
		}
		
		return new Timestamp(d.getTime());

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {
		
		long l = ((Timestamp)obj).getTime();
		
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date(l));

	}

}
