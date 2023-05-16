package br.com.NourishMe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.NourishMe.repository.UsuarioRepository;

public class AuthenticationService implements UserDetailsService {
    
    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                    .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
