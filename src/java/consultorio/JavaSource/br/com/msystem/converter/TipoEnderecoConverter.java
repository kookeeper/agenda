package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.TipoEndereco;

@FacesConverter("tipoEnderecoConverter")
public class TipoEnderecoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Object tipoEndereco = context.getViewRoot().getViewMap().get(value);

		return tipoEndereco;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		String key = "TipoEndereco" + ((TipoEndereco) obj).getTipoEnderecoSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;
		
	}

}
