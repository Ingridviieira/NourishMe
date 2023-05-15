package br.com.NourishMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.NourishMe.models.Motivo;


@Repository
public interface MotivoRepository extends JpaRepository<Motivo, Long> {

}

