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
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_forma_pagamento;

    private String nome_forma_pagamento;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "conta_pagar_forma_pagamento")
    private List<ContaPagar> contaPagar;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "conta_receber_forma_pagamento")
    private List<ContaReceber> contaReceber;

    public FormaPagamento(){}

    public FormaPagamento(Long id_forma_pagamento, String nome_forma_pagamento, List<ContaPagar> contaPagar, List<ContaReceber> contaReceber) {
        this.id_forma_pagamento = id_forma_pagamento;
        this.nome_forma_pagamento = nome_forma_pagamento;
        this.contaPagar = contaPagar;
        this.contaReceber = contaReceber;
    }

    public Long getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(Long id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getNome_forma_pagamento() {
        return nome_forma_pagamento;
    }

    public void setNome_forma_pagamento(String nome_forma_pagamento) {
        this.nome_forma_pagamento = nome_forma_pagamento;
    }

    public List<ContaPagar> getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(List<ContaPagar> contaPagar) {
        this.contaPagar = contaPagar;
    }

    public List<ContaReceber> getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(List<ContaReceber> contaReceber) {
        this.contaReceber = contaReceber;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "id_forma_pagamento=" + id_forma_pagamento +
                ", nome_forma_pagamento='" + nome_forma_pagamento + '\'' +
                ", contaPagar=" + contaPagar +
                ", contaReceber=" + contaReceber +
                '}';
    }
}
