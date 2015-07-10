package br.com.msystem.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

public abstract class AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7715245415525727284L;
	
	@ManagedProperty("#{userSession}")
	private UserSession session;

	/**
	 * @return the session
	 */
	public UserSession getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(UserSession session) {
		this.session = session;
	}

}
