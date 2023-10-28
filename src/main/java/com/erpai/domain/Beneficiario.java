package com.erpai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_beneficiario;

    private String nome_beneficiario;


    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "beneficiario")
    private List<ContaPagar> contaPagar;

    public Beneficiario(){}

    public Beneficiario(Long id_beneficiario, String nome_beneficiario, List<ContaPagar> contaPagar) {
        this.id_beneficiario = id_beneficiario;
        this.nome_beneficiario = nome_beneficiario;
        this.contaPagar = contaPagar;
    }

    public Long getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(Long id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }

    public String getNome_beneficiario() {
        return nome_beneficiario;
    }

    public void setNome_beneficiario(String nome_beneficiario) {
        this.nome_beneficiario = nome_beneficiario;
    }

    public List<ContaPagar> getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(List<ContaPagar> contaPagar) {
        this.contaPagar = contaPagar;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "id_beneficiario=" + id_beneficiario +
                ", nome_beneficiario='" + nome_beneficiario + '\'' +
                ", contaPagar=" + contaPagar +
                '}';
    }
}
