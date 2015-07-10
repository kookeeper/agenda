package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.TipoTelefone;

@FacesConverter("tipoTelefoneConverter")
public class TipoTelefoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Object tipoTelefone = context.getViewRoot().getViewMap().get(value);

		return tipoTelefone;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		String key = "TipoTelefone" + ((TipoTelefone) obj).getTipoTelefoneSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;
		
	}

}
