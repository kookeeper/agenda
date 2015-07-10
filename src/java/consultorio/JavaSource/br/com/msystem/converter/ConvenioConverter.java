package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.Convenio;

@FacesConverter("convenioConverter")
public class ConvenioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Object entity = context.getViewRoot().getViewMap().get(value);

		return entity;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		if (obj == null) {
			return null;
		}

		String key = "Convenio" + ((Convenio) obj).getConvenioSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;
		
	}

}
