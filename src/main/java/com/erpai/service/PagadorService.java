package com.erpai.service;

import com.erpai.domain.Pagador;
import com.erpai.repository.PagadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagadorService {

    @Autowired
    private PagadorRepository pagadorRepository;

    // Lista todos os pagadores no banco de dados
    public List<Pagador> listarPagadores() {
        return pagadorRepository.findAll();
    }

    // Encontra um pagador por seu ID
    public Optional<Pagador> encontrarPagadorPorId(Long id) {
        return pagadorRepository.findById(id);
    }

    // Salva um novo pagador no banco de dados
    public Pagador salvarPagador(Pagador pagador) {
        return pagadorRepository.save(pagador);
    }

    // Exclui um pagador do banco de dados com base no ID
    public void excluirPagador(Long id) {
        pagadorRepository.deleteById(id);
    }

    // Atualiza um pagador existente no banco de dados com base no ID
    public Pagador atualizarPagador(Long id, Pagador novoPagador) {
        if (encontrarPagadorPorId(id).isPresent()) {
            novoPagador.setId_pagador(id);
            return pagadorRepository.save(novoPagador);
        } else {
            // Lida com o caso em que o pagador com o ID especificado não existe.
            return null;
        }
    }
}
