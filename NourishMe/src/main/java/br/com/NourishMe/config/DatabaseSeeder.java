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
        Motivo m3 = new Motivo(1L, "Me senti bem na janta");
        Motivo m4 = new Motivo(2L, "Estou arrependido de ter jantado");
        Motivo m5 = new Motivo(1L, "Me senti mal porque comi demais");
        Motivo m6 = new Motivo(2L, "Acordei tarde e fui tomar café e passei mal");
        motivoRepository.saveAll(List.of(m1,m2));

        refeicaoRepository.saveAll(List.of(
            Refeicao.builder().id(1l).nome("Clara").nomeRefeicao("Lanche da Tarde").motivo(m1).build(),
            Refeicao.builder().id(2l).nome("Julio").nomeRefeicao("Alomoço").motivo(m2).build(),
            Refeicao.builder().id(3l).nome("Hélio").nomeRefeicao("Janta").motivo(m3).build(),
            Refeicao.builder().id(4l).nome("Jorge").nomeRefeicao("Janta").motivo(m4).build(),
            Refeicao.builder().id(5l).nome("Beatriz").nomeRefeicao("Alomoço").motivo(m5).build(),
            Refeicao.builder().id(6l).nome("Rafaela").nomeRefeicao("Café da Manhã").motivo(m6).build()

        ));
    
    }
}
