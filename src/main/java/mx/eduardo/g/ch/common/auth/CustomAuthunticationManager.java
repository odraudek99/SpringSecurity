package mx.eduardo.g.ch.common.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Clase que provee la autenticación customizada
 * @author GACE861013
 *
 */
public class CustomAuthunticationManager extends AbstractUserDetailsAuthenticationProvider {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		logger.info("additionalAuthenticationChecks... ");
		
	}

	@Override
	protected UserDetails retrieveUser(String arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		
		logger.info("Entra a: retrieveUser");
		
		// Asignación de roles
		List<GrantedAuthority> grantedAuth = new ArrayList<GrantedAuthority>();
		grantedAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		logger.info("arg0: " + arg0);
		logger.info("arg1.getName(): " + arg1.getName());
		logger.info("arg1.getPrincipal(): " + arg1.getPrincipal());
		logger.info("arg1.getCredentials(): " + arg1.getCredentials());
		
		UserDetails user = null; 
				
		if ("eduardo".equals(arg1.getName()) && "password".equals(arg1.getCredentials())) {
			// Define el usuario
			user = new MyUserDetails("user", "password", true, true, 
					true,true, grantedAuth );
			
			
			
		} else {
			throw new BadCredentialsException("pwd incorrecto");
		}
		return user;
	}

	
	



}
