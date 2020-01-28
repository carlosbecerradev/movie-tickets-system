package pe.wolke.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return "iniciar_sesion";		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) 
    {
        //se obtiene el usuario autenticado
        Authentication auth=SecurityContextHolder.
                            getContext().getAuthentication();
        
        //si existe el usuario autenticado, cerrar sesión
        if(auth!=null)    
        {
            //cerrar sesión
            new SecurityContextLogoutHandler().
                    logout(request,response,auth);
        }

        //si no existe el usuario autenticadi, redireccionar a login
        return "redirect:login?logout";
    }
	
	// accesso_denegado
	@RequestMapping(value="/accesso_denegado",method=RequestMethod.GET)
	public String accesso_denegado() {
		
		return "redirect:login?accesso_denegado";
	}
	
	
}
