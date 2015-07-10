package br.com.msystem.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.msystem.mbean.UserSession;

@FacesValidator("br.com.msystem.validator.passwordValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {

		UserSession userSession = (UserSession) ctx.getExternalContext()
				.getSessionMap().get("userSession");
		
		if (userSession.getUser().getPassword().equals(value.toString())) {
			FacesMessage message = new FacesMessage("A senha informada não é válida.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message );
		}

	}

}
