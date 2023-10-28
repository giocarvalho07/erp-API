package com.erpai.service;

import com.erpai.domain.ContaReceber;
import com.erpai.repository.ContaReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaReceberService {

    @Autowired
    private ContaReceberRepository contaReceberRepository;

    // Lista todas as contas a receber no banco de dados
    public List<ContaReceber> listarContasReceber() {
        return contaReceberRepository.findAll();
    }

    // Encontra uma conta a receber por seu ID
    public Optional<ContaReceber> encontrarContaReceberPorId(Long id) {
        return contaReceberRepository.findById(id);
    }

    // Salva uma nova conta a receber no banco de dados
    public ContaReceber salvarContaReceber(ContaReceber contaReceber) {
        return contaReceberRepository.save(contaReceber);
    }

    // Exclui uma conta a receber do banco de dados com base no ID
    public void excluirContaReceber(Long id) {
        contaReceberRepository.deleteById(id);
    }

    // Atualiza uma conta a receber existente no banco de dados com base no ID
    public ContaReceber atualizarContaReceber(Long id, ContaReceber novaContaReceber) {
        if (encontrarContaReceberPorId(id).isPresent()) {
            novaContaReceber.setId_conta_receber(id);
            return contaReceberRepository.save(novaContaReceber);
        } else {
            // Lida com o caso em que a conta a receber com o ID especificado não existe.
            return null;
        }
    }
}
