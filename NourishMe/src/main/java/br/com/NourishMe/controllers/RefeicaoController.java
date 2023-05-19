package br.com.NourishMe.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.NourishMe.exception.RestNotFoundException;
import br.com.NourishMe.models.Refeicao;
import br.com.NourishMe.repository.MotivoRepository;
import br.com.NourishMe.repository.RefeicaoRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/refeicoes")
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(RefeicaoController.class);


    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Autowired
    private MotivoRepository motivoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable) {
        var refeicao = (busca == null) ? 
        refeicaoRepository.findAll(pageable): 
        refeicaoRepository.findByNomeContaining(busca, pageable);

        return assembler.toModel(refeicao.map(Refeicao::toEntityModel)); 
    }

    @PostMapping
    public ResponseEntity<EntityModel<Refeicao>> create( 
        @RequestBody @Valid Refeicao refeicao, 
        BindingResult result
        ){
        log.info("cadastro de refeição: " + refeicao);
        refeicaoRepository.save(refeicao);
        refeicao.setMotivo(motivoRepository.findById(refeicao.getMotivo().getId()).get());
        return ResponseEntity
        .created(refeicao.toEntityModel().getRequiredLink("self").toUri())
        .body(refeicao.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Refeicao> show(
        @PathVariable Long id
        ){
        log.info("Buscando Refeição: " + id);
        return getRefeicao(id).toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Refeicao> destroy(
        @PathVariable Long id
        ){
        log.info("Apagando Refeição: " + id);
        refeicaoRepository.delete(getRefeicao(id));
        return ResponseEntity.noContent().build();  
    }

    @PutMapping("{id}")
    public ResponseEntity<Refeicao> update(
        @PathVariable Long id, 
        @RequestBody @Valid Refeicao refeicao
        ){
        log.info("Editar a refeição: " + id);
        getRefeicao(id);
        refeicao.setId(id);
        refeicaoRepository.save(refeicao);
        return ResponseEntity.ok(refeicao);
        }

        private Refeicao getRefeicao(Long id) {
            return refeicaoRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("Refeição não encontrado"));
        }




}
