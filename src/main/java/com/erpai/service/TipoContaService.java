package com.erpai.service;

import com.erpai.domain.TipoConta;
import com.erpai.repository.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContaService {

    @Autowired
    private TipoContaRepository tipoContaRepository;

    // Lista todos os tipos de conta no banco de dados
    public List<TipoConta> listarTiposConta() {
        return tipoContaRepository.findAll();
    }

    // Encontra um tipo de conta por seu ID
    public Optional<TipoConta> encontrarTipoContaPorId(Long id) {
        return tipoContaRepository.findById(id);
    }

    // Salva um novo tipo de conta no banco de dados
    public TipoConta salvarTipoConta(TipoConta tipoConta) {
        return tipoContaRepository.save(tipoConta);
    }

    // Exclui um tipo de conta do banco de dados com base no ID
    public void excluirTipoConta(Long id) {
        tipoContaRepository.deleteById(id);
    }

    // Atualiza um tipo de conta existente no banco de dados com base no ID
    public TipoConta atualizarTipoConta(Long id, TipoConta novoTipoConta) {
        if (encontrarTipoContaPorId(id).isPresent()) {
            novoTipoConta.setId_tipo_conta(id);
            return tipoContaRepository.save(novoTipoConta);
        } else {
            // Lida com o caso em que o tipo de conta com o ID especificado não existe.
            return null;
        }
    }
}
