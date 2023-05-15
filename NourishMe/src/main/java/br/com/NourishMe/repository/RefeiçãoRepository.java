package br.com.NourishMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.NourishMe.models.Refeição;

@Repository
public interface RefeiçãoRepository extends JpaRepository<Refeição, Long> {

}

