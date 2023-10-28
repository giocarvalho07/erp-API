package com.erpai.service;

import com.erpai.domain.ContaPagar;
import com.erpai.repository.ContaPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContaPagarService {

    @Autowired
    private ContaPagarRepository contaPagarRepository;

    // Lista todas as contas a pagar no banco de dados
    public List<ContaPagar> listarContasPagar() {
        return contaPagarRepository.findAll();
    }

    // Encontra uma conta a pagar por seu ID
    public Optional<ContaPagar> encontrarContaPagarPorId(Long id) {
        return contaPagarRepository.findById(id);
    }

    // Salva uma nova conta a pagar no banco de dados
    public ContaPagar salvarContaPagar(ContaPagar contaPagar) {
        return contaPagarRepository.save(contaPagar);
    }

    // Exclui uma conta a pagar do banco de dados com base no ID
    public void excluirContaPagar(Long id) {
        contaPagarRepository.deleteById(id);
    }

    // Atualiza uma conta a pagar existente no banco de dados com base no ID
    public ContaPagar atualizarContaPagar(Long id, ContaPagar novaContaPagar) {
        if (encontrarContaPagarPorId(id).isPresent()) {
            novaContaPagar.setId_conta_pagar(id);
            return contaPagarRepository.save(novaContaPagar);
        } else {
            // Lida com o caso em que a conta a pagar com o ID especificado não existe.
            return null;
        }
    }
}
