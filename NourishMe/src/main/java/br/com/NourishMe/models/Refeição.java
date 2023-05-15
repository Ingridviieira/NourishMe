package br.com.NourishMe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Refeição {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; //nome da refeição ex café da manha
    private String descricao; //o que comecu
    private double valor;

    @ManyToOne
    private Motivo motivo;
//-------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public double setMotivo(Motivo motivo) {
        this.motivo = motivo;
        return id;
    }

    public Refeição(Long id, String nome, String descricao, double valor, Motivo motivo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.motivo = motivo;
    }

    
}
