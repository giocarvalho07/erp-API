package com.erpai.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
@Getter
@Setter
public class Informativo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_informativo;

    private String titulo;

    private String descricao_informativo;

    private String data_informativo;

    public Informativo(){}

    public Informativo(Long id_informativo, String titulo, String descricao_informativo, String data_informativo) {
        this.id_informativo = id_informativo;
        this.titulo = titulo;
        this.descricao_informativo = descricao_informativo;
        this.data_informativo = data_informativo;
    }

    public Long getId_informativo() {
        return id_informativo;
    }

    public void setId_informativo(Long id_informativo) {
        this.id_informativo = id_informativo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao_informativo() {
        return descricao_informativo;
    }

    public void setDescricao_informativo(String descricao_informativo) {
        this.descricao_informativo = descricao_informativo;
    }

    public String getData_informativo() {
        return data_informativo;
    }

    public void setData_informativo(String data_informativo) {
        this.data_informativo = data_informativo;
    }

    @Override
    public String toString() {
        return "Informativo{" +
                "id_informativo=" + id_informativo +
                ", titulo='" + titulo + '\'' +
                ", descricao_informativo='" + descricao_informativo + '\'' +
                ", data_informativo='" + data_informativo + '\'' +
                '}';
    }

}
