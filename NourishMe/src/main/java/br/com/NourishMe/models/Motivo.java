package br.com.NourishMe.models;

import org.springframework.hateoas.EntityModel;

import br.com.NourishMe.controllers.MotivoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_MOTIVO")
public class Motivo {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 1000, message = "deve ser o motivo significativo")
    private String descricaoMotivo;
    
    public EntityModel<Motivo> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(MotivoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(MotivoController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(MotivoController.class).index(null, Pageable.unpaged())).withRel("all")

        );
    }
}