package br.com.NourishMe.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.NourishMe.models.Motivo;
import br.com.NourishMe.models.Refeicao;
import br.com.NourishMe.repository.MotivoRepository;
import br.com.NourishMe.repository.RefeicaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Autowired
    MotivoRepository motivoRepository;

    @Override
    public void run(String... args) throws Exception {

        Motivo m1 = new Motivo(1L, "Me senti mal depois de ir mal em uma prova");
        Motivo m2 = new Motivo(2L, "Almocei no horario certo hoje e estou me sentindo bem");
        motivoRepository.saveAll(List.of(m1,m2));

        refeicaoRepository.saveAll(List.of(
            Refeicao.builder().id(1l).nome("Clara").nomeRefeicao("Lanche da Tarde").motivo(new Motivo(m1.getId())).build(),
            Refeicao.builder().id(2l).nome("Julio").nomeRefeicao("Alomoço").motivo(new Motivo(m2.getId())).build()

        ));
    
    }
}
