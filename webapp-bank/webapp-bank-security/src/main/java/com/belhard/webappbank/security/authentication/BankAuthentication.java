package com.belhard.webappbank.security.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.ClientsService;

public class BankAuthentication implements AuthenticationProvider {

	private static final int ADMIN_ACCESS = 1;
	private static final int OPERATOR_ACCESS = 2;
	private static final int USER_ACCESS = 3;
	private static final int NO_ENTRY = 9;

	@Autowired
	ClientsService clientsService;

	@SuppressWarnings("unused")
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName().trim();
		String password = authentication.getCredentials().toString().trim();
		Authentication auth = null;
		ClientBean clientBean = new ClientBean(userName, password);
		clientBean = clientsService.login(clientBean);
		String role = "";
		switch (clientBean.getAccess()) {

		case ADMIN_ACCESS:
			role = "ADMIN";
			break;
		case OPERATOR_ACCESS:
			role = "OPERATOR";
			break;
		case USER_ACCESS:
			role = "USER";
			break;
		case NO_ENTRY:
			throw new BadCredentialsException("Username or password incorrect");

		}

		if (role != null) {
			Collection<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority(role));

			SecurityLoginBean appUser = new SecurityLoginBean(userName, password, true, true, true, true, grantedAuths);
			auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
			return auth;
		}
		return auth;

	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@SuppressWarnings("unused")
	public Authentication login(int id) {
		ClientBean clientBean = clientsService.getClient(id);
		String userName = clientBean.getLogin();
		String password = clientBean.getPass();
		Authentication auth = null;
		String role = "USER";
		if (role != null) {
			Collection<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority(role));

			SecurityLoginBean appUser = new SecurityLoginBean(userName, password, true, true, true, true, grantedAuths);
			auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);

			SecurityContextHolder.getContext().setAuthentication(auth);

			return auth;
		}

		return auth;

	}
}
