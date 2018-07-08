package org.ecad.configuracao.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecad.configuracao.model.Usuario;
import org.ecad.configuracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

//    @Value("${app.user.verification}") 
//    private Boolean requireActivation;
//
//    @Value("${app.secret}")
//    private String applicationSecret;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HttpSession httpSession;

    public final String CURRENT_USER_KEY = "CURRENT_USER";

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(nome);

        if(usuario == null) {
            throw new UsernameNotFoundException(nome);
        }
//        if(requireActivation && !usuario.getToken().equals("1")) {
//            Application.log.error("User [" + nome + "] tried to log in, but his account is not activated.");
//            throw new UsernameNotFoundException(nome + " did not activate his account.");
//        }
        httpSession.setAttribute(CURRENT_USER_KEY, usuario);
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("");

        return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha(), auth);
    }
}