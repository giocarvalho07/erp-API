package com.erpai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List; // Importe a classe List

@Entity
@Data
@Getter
@Setter
public class TipoFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_fornecedor;

    private String produto_servico;

    private String descricao_fornecedor;

    @OneToMany(mappedBy = "tipo_fornecedor")
    @JsonIgnore // Use @JsonIgnore se necessário para evitar recursão
    private List<Fornecedor> fornecedores;

    public TipoFornecedor(){}

    public TipoFornecedor(Long id_tipo_fornecedor, String produto_servico, String descricao_fornecedor, List<Fornecedor> fornecedores) {
        this.id_tipo_fornecedor = id_tipo_fornecedor;
        this.produto_servico = produto_servico;
        this.descricao_fornecedor = descricao_fornecedor;
        this.fornecedores = fornecedores;
    }

    public Long getId_tipo_fornecedor() {
        return id_tipo_fornecedor;
    }

    public void setId_tipo_fornecedor(Long id_tipo_fornecedor) {
        this.id_tipo_fornecedor = id_tipo_fornecedor;
    }

    public String getProduto_servico() {
        return produto_servico;
    }

    public void setProduto_servico(String produto_servico) {
        this.produto_servico = produto_servico;
    }

    public String getDescricao_fornecedor() {
        return descricao_fornecedor;
    }

    public void setDescricao_fornecedor(String descricao_fornecedor) {
        this.descricao_fornecedor = descricao_fornecedor;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public String toString() {
        return "TipoFornecedor{" +
                "id_tipo_fornecedor=" + id_tipo_fornecedor +
                ", produto_servico='" + produto_servico + '\'' +
                ", descricao_fornecedor='" + descricao_fornecedor + '\'' +
                ", fornecedores=" + fornecedores +
                '}';
    }

}
