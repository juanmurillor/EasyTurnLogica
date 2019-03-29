package com.easyturn.presentation.backingBeans;

import com.easyturn.modelo.Usuarios;
import com.easyturn.utilities.*;
import com.easyturn.utilities.FacesUtils;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
                    this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
            Usuarios usuario=(Usuarios)FacesUtils.getfromSession("usuario");
         
            //FacesUtils.getHttpSession(true).setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
            if (usuario.getTipousuario().getIdtipousuario()==1) {
				FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido, Usted ha ingresado como Restaurante",""));
				System.out.println("Entre a Restaurante");
				return "/restaurante/inicioRestaurante.xhtml";
			}else if (usuario.getTipousuario().getIdtipousuario()==4) {
				FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido, Usted ha ingresado como Restaurante",""));
				System.out.println("Entre a ADMIN");
				return "/XHTML/initialMenu.xhtml";
			}else if (usuario.getTipousuario().getIdtipousuario()==2) {
				FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido, Usted ha ingresado como Restaurante",""));
				System.out.println("Entre a Administrador");
				return "/administrador/inicioAdministrador.xhtml";
			}
        } catch (AuthenticationException e) {
            FacesUtils.addErrorMessage("authfailed login or password");

            return "/login.xhtml";
        }

        return "/XHTML/initialMenu.xhtml";
    }
}
