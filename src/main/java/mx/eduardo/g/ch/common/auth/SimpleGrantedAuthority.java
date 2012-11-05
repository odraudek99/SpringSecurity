package mx.eduardo.g.ch.common.auth;

import org.springframework.security.core.GrantedAuthority;

public class SimpleGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private String rol;
	
	public SimpleGrantedAuthority(){}
	
	public SimpleGrantedAuthority(String Rol) {
		this.rol = Rol;
	}
	
	public String getAuthority() {
		return this.rol;
	}

	
}
