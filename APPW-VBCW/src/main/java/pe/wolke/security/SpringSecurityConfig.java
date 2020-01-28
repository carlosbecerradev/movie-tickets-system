package pe.wolke.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import pe.wolke.model.service.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    @Qualifier("customSuccessHandler")
    private SimpleUrlAuthenticationSuccessHandler successHandler;
    
    @Autowired
    @Qualifier("jpaUserDetailsService")
    private JpaUserDetailsService detailsService;
	
  //método para los usuarios autenticados (en memoria)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
        //se verifica el usuario si existe en la BD
        auth.userDetailsService(detailsService);
        
        //el usuario autenticado utiliza servicios del proveedor
        auth.authenticationProvider(daoAuthenticationProvider());

    } 

    //método para las autorizaciones de los usuarios
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        //dando permiso de URLs según el rol del usuario
        http.authorizeRequests()
            .antMatchers("/","/cartelera", "/static/**").permitAll()
            .antMatchers(
            		"/gestion_peliculas/**", 
            		"/gestion_proyecciones/**")
            	.access("hasRole('MARKETERO')")
            .antMatchers(
            		"/gestion_salas/**", 
            		"/gestion_tarifas/**", 
            		"/gestion_butacas/**", 
            		"/reportes/**")
            	.access("hasRole('ADMINISTRADOR')")
            ;
        
        //se usará un fomulario login personalizado
        http.authorizeRequests().and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("contrasenia")
            .successHandler(successHandler);
        
        //URL de mensaje de error de acceso no permitido
        //se busca el value: /access_denied y debe mostrar la página de error
        http.authorizeRequests().and()
            .exceptionHandling().accessDeniedPage("/accesso_denegado");
        
        //protección contra ataques maliciosos
        http.authorizeRequests().and()
            .csrf();
    }  
    
    //bean que especifica el tipo de cifrado
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder pe=new BCryptPasswordEncoder();
        return pe;
    }
    
    //bea que se detalla las provisiones disponibles
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
        //objeto proveedor
        DaoAuthenticationProvider dap=
                new DaoAuthenticationProvider();
        
        dap.setUserDetailsService(detailsService);
        dap.setPasswordEncoder(passwordEncoder());
        
        return dap;                
    }

}
