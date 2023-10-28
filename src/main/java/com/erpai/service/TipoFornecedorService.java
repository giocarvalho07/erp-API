package com.erpai.service;

import com.erpai.domain.TipoFornecedor;
import com.erpai.repository.TipoFornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoFornecedorService {

    private final TipoFornecedorRepository tipoFornecedorRepository;

    public TipoFornecedorService(TipoFornecedorRepository tipoFornecedorRepository) {
        this.tipoFornecedorRepository = tipoFornecedorRepository;
    }

    // Lista todos os tipos de fornecedores no banco de dados
    public List<TipoFornecedor> listarTiposFornecedor() {
        return tipoFornecedorRepository.findAll();
    }

    // Encontra um tipo de fornecedor por seu ID
    public Optional<TipoFornecedor> encontrarTipoFornecedorPorId(Long id) {
        return tipoFornecedorRepository.findById(id);
    }

    // Salva um novo tipo de fornecedor no banco de dados
    public TipoFornecedor salvarTipoFornecedor(TipoFornecedor tipoFornecedor) {
        return tipoFornecedorRepository.save(tipoFornecedor);
    }

    // Exclui um tipo de fornecedor do banco de dados com base no ID
    public void excluirTipoFornecedor(Long id) {
        tipoFornecedorRepository.deleteById(id);
    }

    // Atualiza um tipo de fornecedor existente no banco de dados com base no ID
    public TipoFornecedor atualizarTipoFornecedor(Long id, TipoFornecedor novoTipoFornecedor) {
        if (encontrarTipoFornecedorPorId(id).isPresent()) {
            novoTipoFornecedor.setId_tipo_fornecedor(id);
            return tipoFornecedorRepository.save(novoTipoFornecedor);
        } else {
            // Lida com o caso em que o tipo de fornecedor com o ID especificado não existe.
            return null;
        }
    }
}
