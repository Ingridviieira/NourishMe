package br.com.NourishMe.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.NourishMe.controllers.RefeicaoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo nome não pode ser vazio")
    private String nome; 

    @NotBlank @Max( value= 20, message = "o campo precisa estar com o nome da refeição feita e não pode estar vazio, e com no maximo 20 letras")
    private String nomeRefeicao; //nome da refeição ex café da manha

    // @NotEmpty(message = "O campo nome não pode ser vazio")
    // private String sentimentos; //o que sentiu depois que comeu

    // @Min(value = 0, message = "este campo o valor não pode ser inferior a 0")
    // private double valor;   //quantidade

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
