package com.erpai.service;

import com.erpai.domain.Fornecedor;
import com.erpai.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Lista todos os fornecedores no banco de dados
    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    // Encontra um fornecedor por seu ID
    public Optional<Fornecedor> encontrarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    // Salva um novo fornecedor no banco de dados
    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Exclui um fornecedor do banco de dados com base no ID
    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    // Atualiza um fornecedor existente no banco de dados com base no ID
    public Fornecedor atualizarFornecedor(Long id, Fornecedor novoFornecedor) {
        if (encontrarFornecedorPorId(id).isPresent()) {
            novoFornecedor.setId_fornecedor(id);
            return fornecedorRepository.save(novoFornecedor);
        } else {
            // Lida com o caso em que o fornecedor com o ID especificado não existe.
            return null;
        }
    }
}
