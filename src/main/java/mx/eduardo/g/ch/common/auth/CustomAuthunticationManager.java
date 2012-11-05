package mx.eduardo.g.ch.common.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.UserDetails;

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
		
		List<GrantedAuthority> grantedAuth = new ArrayList<GrantedAuthority>();
		grantedAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		UserDetails user = new MyUserDetails("user", "password", true, true, 
				true,true, grantedAuth );
		return user;
	}

	
	



}
