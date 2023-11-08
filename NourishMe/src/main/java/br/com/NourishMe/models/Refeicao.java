package br.com.NourishMe.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.NourishMe.controllers.RefeicaoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_REFEICAO")
public class Refeicao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 200, message = "Digite o nome")
    private String nome;

    @NotBlank @Size(min = 5, max = 1000, message = "deve ser a descrição completa")
    private String nomeRefeicao; //nome da refeição ex café da manha

    @ManyToOne
    private Motivo motivo;

    public EntityModel<Refeicao> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(RefeicaoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(RefeicaoController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(RefeicaoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(RefeicaoController.class).show(this.getMotivo().getId())).withRel("Motivo da Refeção")
        );
    }

    
}
