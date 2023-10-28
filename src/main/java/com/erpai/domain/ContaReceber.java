package com.erpai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
public class ContaReceber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta_receber;

    private String data_conta_receber;

    private Double valor_conta_receber;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private TipoConta tipo_conta_receber;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private FormaPagamento conta_receber_forma_pagamento;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Pagador conta_receber_pagador;

    public ContaReceber(){}

    public ContaReceber(Long id_conta_receber, String data_conta_receber, Double valor_conta_receber, TipoConta tipo_conta_receber, FormaPagamento conta_receber_forma_pagamento, Pagador conta_receber_pagador) {
        this.id_conta_receber = id_conta_receber;
        this.data_conta_receber = data_conta_receber;
        this.valor_conta_receber = valor_conta_receber;
        this.tipo_conta_receber = tipo_conta_receber;
        this.conta_receber_forma_pagamento = conta_receber_forma_pagamento;
        this.conta_receber_pagador = conta_receber_pagador;
    }

    public Long getId_conta_receber() {
        return id_conta_receber;
    }

    public void setId_conta_receber(Long id_conta_receber) {
        this.id_conta_receber = id_conta_receber;
    }

    public String getData_conta_receber() {
        return data_conta_receber;
    }

    public void setData_conta_receber(String data_conta_receber) {
        this.data_conta_receber = data_conta_receber;
    }

    public Double getValor_conta_receber() {
        return valor_conta_receber;
    }

    public void setValor_conta_receber(Double valor_conta_receber) {
        this.valor_conta_receber = valor_conta_receber;
    }


    public TipoConta getTipo_conta_receber() {
        return tipo_conta_receber;
    }

    public void setTipo_conta_receber(TipoConta tipo_conta_receber) {
        this.tipo_conta_receber = tipo_conta_receber;
    }

    public FormaPagamento getConta_receber_forma_pagamento() {
        return conta_receber_forma_pagamento;
    }

    public void setConta_receber_forma_pagamento(FormaPagamento conta_receber_forma_pagamento) {
        this.conta_receber_forma_pagamento = conta_receber_forma_pagamento;
    }

    public Pagador getConta_receber_pagador() {
        return conta_receber_pagador;
    }

    public void setConta_receber_pagador(Pagador conta_receber_pagador) {
        this.conta_receber_pagador = conta_receber_pagador;
    }

    @Override
    public String toString() {
        return "ContaReceber{" +
                "id_conta_receber=" + id_conta_receber +
                ", data_conta_receber='" + data_conta_receber + '\'' +
                ", valor_conta_receber=" + valor_conta_receber +
                ", tipo_conta_receber=" + tipo_conta_receber +
                ", conta_receber_forma_pagamento=" + conta_receber_forma_pagamento +
                ", conta_receber_pagador=" + conta_receber_pagador +
                '}';
    }
}
