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
public class Pagador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagador;

    private String nome_pagador;

    private String cpf_cnpj;

    private String telefone_pagador;

    private String descricao_pagador;

    private String motivo_pagador;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "conta_receber_pagador")
    private List<ContaReceber> contaReceber;

    public Pagador(){}

    public Pagador(Long id_pagador, String nome_pagador, String cpf_cnpj, String telefone_pagador, String descricao_pagador, String motivo_pagador, List<ContaReceber> contaReceber) {
        this.id_pagador = id_pagador;
        this.nome_pagador = nome_pagador;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone_pagador = telefone_pagador;
        this.descricao_pagador = descricao_pagador;
        this.motivo_pagador = motivo_pagador;
        this.contaReceber = contaReceber;
    }

    public Long getId_pagador() {
        return id_pagador;
    }

    public void setId_pagador(Long id_pagador) {
        this.id_pagador = id_pagador;
    }

    public String getNome_pagador() {
        return nome_pagador;
    }

    public void setNome_pagador(String nome_pagador) {
        this.nome_pagador = nome_pagador;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone_pagador() {
        return telefone_pagador;
    }

    public void setTelefone_pagador(String telefone_pagador) {
        this.telefone_pagador = telefone_pagador;
    }

    public String getDescricao_pagador() {
        return descricao_pagador;
    }

    public void setDescricao_pagador(String descricao_pagador) {
        this.descricao_pagador = descricao_pagador;
    }

    public String getMotivo_pagador() {
        return motivo_pagador;
    }

    public void setMotivo_pagador(String motivo_pagador) {
        this.motivo_pagador = motivo_pagador;
    }

    public List<ContaReceber> getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(List<ContaReceber> contaReceber) {
        this.contaReceber = contaReceber;
    }

    @Override
    public String toString() {
        return "Pagador{" +
                "id_pagador=" + id_pagador +
                ", nome_pagador='" + nome_pagador + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", telefone_pagador='" + telefone_pagador + '\'' +
                ", descricao_pagador='" + descricao_pagador + '\'' +
                ", motivo_pagador='" + motivo_pagador + '\'' +
                ", contaReceber=" + contaReceber +
                '}';
    }
}
