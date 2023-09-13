package br.com.NourishMe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.NourishMe.models.Motivo;


public interface MotivoRepository extends JpaRepository<Motivo, Long> {
    Page<Motivo> findByDescricaoMotivoContaining(String busca, Pageable pageable);

}