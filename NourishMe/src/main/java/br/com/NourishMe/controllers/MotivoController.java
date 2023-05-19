package br.com.NourishMe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.NourishMe.exception.RestNotFoundException;
import br.com.NourishMe.models.Motivo;
import br.com.NourishMe.repository.MotivoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/motivos")
public class MotivoController {

    @Autowired
    MotivoRepository repository;

    @GetMapping
    public List<Motivo> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Motivo> create(
        @RequestBody @Valid Motivo motivo,
        BindingResult result){
        repository.save(motivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(motivo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Motivo> show(@PathVariable Long id){
        
        return ResponseEntity.ok(getMotivo(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Motivo> destroy(@PathVariable Long id){
        repository.delete(getMotivo(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Motivo> update(
        @PathVariable Long id,
        @RequestBody @Valid Motivo motivo
    ){
        getMotivo(id);
        motivo.setId(id);
        repository.save(motivo);
        return ResponseEntity.ok(motivo);
    }

    private Motivo getMotivo(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Motivo não encontrado"));
    }

}
