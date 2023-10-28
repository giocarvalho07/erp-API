package com.erpai.service;

import com.erpai.domain.FormaPagamento;
import com.erpai.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    // Lista todas as formas de pagamento no banco de dados
    public List<FormaPagamento> listarFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    // Encontra uma forma de pagamento por seu ID
    public Optional<FormaPagamento> encontrarFormaPagamentoPorId(Long id) {
        return formaPagamentoRepository.findById(id);
    }

    // Salva uma nova forma de pagamento no banco de dados
    public FormaPagamento salvarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    // Exclui uma forma de pagamento do banco de dados com base no ID
    public void excluirFormaPagamento(Long id) {
        formaPagamentoRepository.deleteById(id);
    }

    // Atualiza uma forma de pagamento existente no banco de dados com base no ID
    public FormaPagamento atualizarFormaPagamento(Long id, FormaPagamento novaFormaPagamento) {
        if (encontrarFormaPagamentoPorId(id).isPresent()) {
            novaFormaPagamento.setId_forma_pagamento(id);
            return formaPagamentoRepository.save(novaFormaPagamento);
        } else {
            // Lida com o caso em que a forma de pagamento com o ID especificado não existe.
            return null;
        }
    }
}
