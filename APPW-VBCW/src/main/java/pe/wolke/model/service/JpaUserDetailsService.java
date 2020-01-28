package pe.wolke.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.wolke.model.dao.IUsuarioDao;
import pe.wolke.model.entity.Rol;
import pe.wolke.model.entity.Usuario;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// Añadiendo rol del usuario
		authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getTipo()));

		return new User(
				usuario.getUsername(), 
				usuario.getContrasenia(), 
				usuario.getEstado(), 
				true, true, true, 
				authorities);
	}
	
}
