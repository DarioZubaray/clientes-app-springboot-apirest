package com.github.dariozubaray.springboot.api.rest.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.dariozubaray.springboot.api.rest.models.dao.IUsuarioDao;
import com.github.dariozubaray.springboot.api.rest.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {
            String errorMsg = "No existe el usuario '"+username+"' en el sistema";
            logger.error(errorMsg);
            throw new UsernameNotFoundException(errorMsg);
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // @formatter:off
        List<GrantedAuthority> authorities = usuario.getRoles()
                                                    .stream()
                                                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                                                    .peek(authoritie -> logger.info("Role: {}", authoritie.getAuthority()))
                                                    .collect(Collectors.toList());

        return new User(usuario.getUsername(),
                        usuario.getPassword(),
                        usuario.getEnabled(),
                        accountNonExpired,
                        credentialsNonExpired,
                        accountNonLocked,
                        authorities);
       // @formatter:on
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

}
