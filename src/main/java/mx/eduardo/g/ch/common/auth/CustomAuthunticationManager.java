package mx.eduardo.g.ch.common.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthunticationManager implements AuthenticationProvider {
	
	protected final Log logger = LogFactory.getLog(getClass());

	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		logger.info("authentication.getName: " + authentication.getName());
		logger.info("authentication.getDetails: " + authentication.getDetails());
		logger.info("authentication.getPrincipal: " + authentication.getPrincipal());
		
		
		
		authentication.setAuthenticated(true);
		return authentication;
	}

	public boolean supports(Class<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	



}
