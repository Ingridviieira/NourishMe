package br.com.NourishMe.repository;

import br.com.NourishMe.models.Refeicao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    Page<Refeicao> findByNomeContaining(String busca, Pageable pageable);

}


