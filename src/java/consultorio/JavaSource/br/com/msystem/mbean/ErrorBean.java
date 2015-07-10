package br.com.msystem.mbean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean
@ApplicationScoped
public class ErrorBean {

	public String getMensagem() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		Flash flash = ctx.getExternalContext().getFlash();
		return (String) flash.get("errorDetails");

	}
}