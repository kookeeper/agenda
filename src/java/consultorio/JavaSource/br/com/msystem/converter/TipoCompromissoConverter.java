package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.TipoCompromisso;

@FacesConverter("tipoCompromissoConverter")
public class TipoCompromissoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Object entity = context.getViewRoot().getViewMap().get(value);

		return entity;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		String key = "TipoCompromisso" + ((TipoCompromisso) obj).getTipoCompromissoSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;
		
	}

}
