package com.easyturn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import com.easyturn.modelo.Usuarios;
import com.easyturn.presentation.businessDelegate.BusinessDelegatorView;
import com.easyturn.presentation.businessDelegate.IBusinessDelegatorView;
import com.easyturn.utilities.FacesUtils;


import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
    /**
     * Security Implementation
     */
	@Autowired
	private IBusinessDelegatorView iBusinessDelegatorView;
	
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
			Usuarios usuario = iBusinessDelegatorView.getUsuarios(name);
			/*if (name.equals("admin") && password.equals("admin")) {
	            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

	            final UserDetails principal = new User(name, password, grantedAuths);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
	                    password, grantedAuths);
	            FacesUtils.putinSession("usuario", usuario);
	            return auth;
	        }*/
			if (usuario.getTipousuario().getIdtipousuario()==4) {
	            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

	            final UserDetails principal = new User(name, password, grantedAuths);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
	                    password, grantedAuths);
	            FacesUtils.putinSession("usuario", usuario);
	            return auth;
	        }else if (usuario.getTipousuario().getIdtipousuario()==1) {
				final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_RESTAURANTE"));
				
				final UserDetails principal = new User(name, password, grantedAuths);
				final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password,
						grantedAuths);
				FacesUtils.putinSession("usuario", usuario);

				return auth;
			} else if (usuario.getTipousuario().getIdtipousuario()==2) {
				final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));
				
				final UserDetails principal = new User(name, password, grantedAuths);
				final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password,
						grantedAuths);
				FacesUtils.putinSession("usuario", usuario);

				return auth;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        {
        	return null;
        }
        
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
