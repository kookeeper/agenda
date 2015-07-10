package br.com.msystem.db.to;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityTO implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6897403686902291942L;
	private String authority;

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
