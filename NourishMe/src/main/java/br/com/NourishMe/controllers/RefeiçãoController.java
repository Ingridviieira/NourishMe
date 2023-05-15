package br.com.NourishMe.controllers;

import java.util.List;

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

import br.com.NourishMe.models.Refeição;
import br.com.NourishMe.repository.MotivoRepository;
import br.com.NourishMe.repository.RefeiçãoRepository;

@RestController
@RequestMapping("/refeicoes")
public class RefeiçãoController {

    @Autowired
    private RefeiçãoRepository refeiçãoRepository;

    @Autowired
    private MotivoRepository motivoRepository;

    @PostMapping
    public Refeição criarRefeição(@RequestBody Refeição refeição) {
        return refeiçãoRepository.save(refeição);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refeição> atualizarRefeição(@PathVariable Long id, @RequestBody Refeição refeiçãoAtualizada) {
        Optional<Refeição> refeiçãoOptional = refeiçãoRepository.findById(id);
        if (refeiçãoOptional.isPresent()) {
            Refeição refeição = refeiçãoOptional.get();
            refeição.setNome(refeiçãoAtualizada.getNome());
            refeição.setValor(refeição.setMotivo(refeiçãoAtualizada.getMotivo());
            Refeição refeiçãoSalva = refeiçãoRepository.save(refeição);
            return ResponseEntity.ok(refeiçãoSalva);
            } else {
            return ResponseEntity.notFound().build();
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRefeição(@PathVariable Long id) {
        Optional<Refeição> refeiçãoOptional = refeiçãoRepository.findById(id);
        if (refeiçãoOptional.isPresent()) {
            Refeição refeição = refeiçãoOptional.get();
            refeiçãoRepository.delete(refeição);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
}

    @GetMapping
    public List<Refeição> listarRefeições() {
        return refeiçãoRepository.findAll();
    }

}
