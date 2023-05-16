package br.com.NourishMe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.NourishMe.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);
}

