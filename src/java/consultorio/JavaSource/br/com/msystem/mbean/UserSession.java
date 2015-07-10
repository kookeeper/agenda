package br.com.msystem.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.msystem.db.to.UserDetailsTO;

@ManagedBean
@SessionScoped
public class UserSession implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3650541105994154129L;
	private UserDetailsTO user;
    
    public UserDetailsTO getUser() {
        return user;
    }
 
    public void setUser(UserDetailsTO user) {
        this.user = user;
    }
     
    public boolean isLoggedIn(){
        return user != null;
    }

}
