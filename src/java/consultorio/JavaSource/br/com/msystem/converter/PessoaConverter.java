package br.com.msystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.msystem.db.entity.Pessoa;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Object pessoa = context.getViewRoot().getViewMap().get(value);

		return pessoa;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		
		String key = "Pessoa" + ((Pessoa) obj).getPessoaSq().toString();

		context.getViewRoot().getViewMap().put(key, obj);

		return key;

	}

}
