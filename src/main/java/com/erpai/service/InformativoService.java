package com.erpai.service;

import com.erpai.domain.Informativo;
import com.erpai.repository.InformativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InformativoService {

    @Autowired
    private InformativoRepository informativoRepository;

    // Lista todos os informativos no banco de dados
    public List<Informativo> listarInformativos() {
        return informativoRepository.findAll();
    }

    // Encontra um informativo por seu ID
    public Optional<Informativo> encontrarInformativoPorId(Long id) {
        return informativoRepository.findById(id);
    }

    // Salva um novo informativo no banco de dados
    public Informativo salvarInformativo(Informativo informativo) {
        return informativoRepository.save(informativo);
    }

    // Exclui um informativo do banco de dados com base no ID
    public void excluirInformativo(Long id) {
        informativoRepository.deleteById(id);
    }

    // Atualiza um informativo existente no banco de dados com base no ID
    public Informativo atualizarInformativo(Long id, Informativo novoInformativo) {
        if (encontrarInformativoPorId(id).isPresent()) {
            novoInformativo.setId_informativo(id);
            return informativoRepository.save(novoInformativo);
        } else {
            // Lida com o caso em que o informativo com o ID especificado não existe.
            return null;
        }
    }
}
