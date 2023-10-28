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
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta_pagar;

    private String data_conta_pagar;

    private Double valor_conta_pagar;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Beneficiario beneficiario;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private TipoConta tipo_conta_pagar;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private FormaPagamento conta_pagar_forma_pagamento;

    public ContaPagar(){}

    public ContaPagar(Long id_conta_pagar, String data_conta_pagar, Double valor_conta_pagar, Beneficiario beneficiario, TipoConta tipo_conta_pagar, FormaPagamento conta_pagar_forma_pagamento) {
        this.id_conta_pagar = id_conta_pagar;
        this.data_conta_pagar = data_conta_pagar;
        this.valor_conta_pagar = valor_conta_pagar;
        this.beneficiario = beneficiario;
        this.tipo_conta_pagar = tipo_conta_pagar;
        this.conta_pagar_forma_pagamento = conta_pagar_forma_pagamento;
    }

    public Long getId_conta_pagar() {
        return id_conta_pagar;
    }

    public void setId_conta_pagar(Long id_conta_pagar) {
        this.id_conta_pagar = id_conta_pagar;
    }

    public String getData_conta_pagar() {
        return data_conta_pagar;
    }

    public void setData_conta_pagar(String data_conta_pagar) {
        this.data_conta_pagar = data_conta_pagar;
    }

    public Double getValor_conta_pagar() {
        return valor_conta_pagar;
    }

    public void setValor_conta_pagar(Double valor_conta_pagar) {
        this.valor_conta_pagar = valor_conta_pagar;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public TipoConta getTipo_conta_pagar() {
        return tipo_conta_pagar;
    }

    public void setTipo_conta_pagar(TipoConta tipo_conta_pagar) {
        this.tipo_conta_pagar = tipo_conta_pagar;
    }

    public FormaPagamento getConta_pagar_forma_pagamento() {
        return conta_pagar_forma_pagamento;
    }

    public void setConta_pagar_forma_pagamento(FormaPagamento conta_pagar_forma_pagamento) {
        this.conta_pagar_forma_pagamento = conta_pagar_forma_pagamento;
    }

    @Override
    public String toString() {
        return "ContaPagar{" +
                "id_conta_pagar=" + id_conta_pagar +
                ", data_conta_pagar='" + data_conta_pagar + '\'' +
                ", valor_conta_pagar=" + valor_conta_pagar +
                ", beneficiario=" + beneficiario +
                ", tipo_conta_pagar=" + tipo_conta_pagar +
                ", conta_pagar_forma_pagamento=" + conta_pagar_forma_pagamento +
                '}';
    }
}
