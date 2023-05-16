package br.com.NourishMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.NourishMe.models.Motivo;


public interface MotivoRepository extends JpaRepository<Motivo, Long> {

}