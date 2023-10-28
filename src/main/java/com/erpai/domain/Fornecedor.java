package com.erpai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne; // Importe esta anotação
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fornecedor;

    private String nome_fornecedor;

    private String telefone;

    private String email;

    private String cpf_cnpj;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private TipoFornecedor tipo_fornecedor;

    public Fornecedor(){}

    public Fornecedor(Long id_fornecedor, String nome_fornecedor, String telefone, String email, String cpf_cnpj, TipoFornecedor tipo_fornecedor) {
        this.id_fornecedor = id_fornecedor;
        this.nome_fornecedor = nome_fornecedor;
        this.telefone = telefone;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.tipo_fornecedor = tipo_fornecedor;
    }

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public TipoFornecedor getTipo_fornecedor() {
        return tipo_fornecedor;
    }

    public void setTipo_fornecedor(TipoFornecedor tipo_fornecedor) {
        this.tipo_fornecedor = tipo_fornecedor;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id_fornecedor=" + id_fornecedor +
                ", nome_fornecedor='" + nome_fornecedor + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", tipo_fornecedor=" + tipo_fornecedor +
                '}';
    }
}
