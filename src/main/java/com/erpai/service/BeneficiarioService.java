package com.erpai.service;

import com.erpai.domain.Beneficiario;
import com.erpai.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    // Lista todos os beneficiários no banco de dados
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    // Encontra um beneficiário por seu ID
    public Optional<Beneficiario> encontrarBeneficiarioPorId(Long id) {
        return beneficiarioRepository.findById(id);
    }

    // Salva um novo beneficiário no banco de dados
    public Beneficiario salvarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    // Exclui um beneficiário do banco de dados com base no ID
    public void excluirBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }

    // Atualiza um beneficiário existente no banco de dados com base no ID
    public Beneficiario atualizarBeneficiario(Long id, Beneficiario novoBeneficiario) {
        if (encontrarBeneficiarioPorId(id).isPresent()) {
            novoBeneficiario.setId_beneficiario(id);
            return beneficiarioRepository.save(novoBeneficiario);
        } else {
            // Lida com o caso em que o beneficiário com o ID especificado não existe.
            return null;
        }
    }
}
