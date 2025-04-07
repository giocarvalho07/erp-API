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
public class TipoConta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_conta;

    private String nome_tipo_conta;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "tipo_conta_pagar")
    private List<ContaPagar> contaPagar;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "tipo_conta_receber")
    private List<ContaReceber> contaReceber;

    public TipoConta(){}

    public TipoConta(Long id_tipo_conta, String nome_tipo_conta, List<ContaPagar> contaPagar, List<ContaReceber> contaReceber) {
        this.id_tipo_conta = id_tipo_conta;
        this.nome_tipo_conta = nome_tipo_conta;
        this.contaPagar = contaPagar;
        this.contaReceber = contaReceber;
    }

    public Long getId_tipo_conta() {
        return id_tipo_conta;
    }

    public void setId_tipo_conta(Long id_tipo_conta) {
        this.id_tipo_conta = id_tipo_conta;
    }

    public String getNome_tipo_conta() {
        return nome_tipo_conta;
    }

    public void setNome_tipo_conta(String nome_tipo_conta) {
        this.nome_tipo_conta = nome_tipo_conta;
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
        return "TipoConta{" +
                "id_tipo_conta=" + id_tipo_conta +
                ", nome_tipo_conta='" + nome_tipo_conta + '\'' +
                ", contaPagar=" + contaPagar +
                ", contaReceber=" + contaReceber +
                '}';
    }

    public short getId() {
        return 0;
    }

    public short getNome() {
        return 0;
    }
}
