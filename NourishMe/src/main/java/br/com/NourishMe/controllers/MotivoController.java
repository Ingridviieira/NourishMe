package br.com.NourishMe.controllers;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.NourishMe.models.Motivo;
import br.com.NourishMe.repository.MotivoRepository;

@RestController
@RequestMapping("/motivos")
public class MotivoController {

    @Autowired
    private MotivoRepository motivoRepository;

    @PostMapping
    public Motivo criarMotivo(@RequestBody Motivo motivo) {
        return motivoRepository.save(motivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motivo> atualizarMotivo(@PathVariable Long id, @RequestBody Motivo motivoAtualizado) {
        Optional<Motivo> motivoOptional = motivoRepository.findById(id);
        if (motivoOptional.isPresent()) {
            Motivo motivo = motivoOptional.get();
            motivo.setNome(motivoAtualizado.getNome());
            Motivo motivoSalvo = motivoRepository.save(motivo);
            return ResponseEntity.ok(motivoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMotivo(@PathVariable Long id) {
        Optional<Motivo> motivoOptional = motivoRepository.findById(id);
        if (motivoOptional.isPresent()) {
            Motivo motivo = motivoOptional.get();
            motivoRepository.delete(motivo);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Motivo> listarMotivos() {
        return motivoRepository.findAll();
    }

    
    
}
