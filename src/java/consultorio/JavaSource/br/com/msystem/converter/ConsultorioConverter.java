package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.Consultorio;

@FacesConverter("consultorioConverter")
public class ConsultorioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Object consultorio = context.getViewRoot().getViewMap().get(value);

		return consultorio;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		String key = "Consultorio" + ((Consultorio) obj).getConsultorioSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;
		
	}

}
