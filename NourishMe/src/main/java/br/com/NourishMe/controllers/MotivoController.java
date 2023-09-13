package br.com.NourishMe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.NourishMe.exception.RestNotFoundException;
import br.com.NourishMe.models.Motivo;
import br.com.NourishMe.repository.MotivoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/motivos")
@Slf4j
public class MotivoController {

    @Autowired
    MotivoRepository motivoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable) {
        var motivo = (busca == null) ? 
            motivoRepository.findAll(pageable): 
            motivoRepository.findByDescricaoMotivoContaining(busca, pageable);

        return assembler.toModel(motivo.map(Motivo::toEntityModel)); 
    }


    public ResponseEntity<EntityModel<Motivo>> create(
            @RequestBody @Valid Motivo motivo,
            BindingResult result) {
        log.info("cadastrando informação: " + motivo);
        motivoRepository.save(motivo);
        return ResponseEntity
            .created(motivo.toEntityModel().getRequiredLink("self").toUri())
            .body(motivo.toEntityModel());
    }

    public EntityModel<Motivo> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getMotivo(id).toEntityModel();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Motivo> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        motivoRepository.delete(getMotivo(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<Motivo>> update(
            @PathVariable Long id,
            @RequestBody @Valid Motivo motivo) {
        log.info("atualizando informação: " + id);
        getMotivo(id);
        motivo.setId(id);
        motivoRepository.save(motivo);
        return ResponseEntity.ok(motivo.toEntityModel());
    }

    private Motivo getMotivo(Long id) {
        return motivoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("informação não encontrada"));
    }

}
