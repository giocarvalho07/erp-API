package com.erpai.controller;

import com.erpai.domain.Beneficiario;
import com.erpai.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    // Retorna a lista de todos os beneficiários
    @GetMapping
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioService.listarBeneficiarios();
    }

    // Retorna um beneficiário por ID
    @GetMapping("/{id}")
    public Beneficiario encontrarBeneficiarioPorId(@PathVariable Long id) {
        return beneficiarioService.encontrarBeneficiarioPorId(id)
                .orElse(null); // Lida com o caso em que o beneficiário não existe
    }

    // Cria um novo beneficiário
    @PostMapping
    public Beneficiario salvarBeneficiario(@RequestBody Beneficiario beneficiario) {
        return beneficiarioService.salvarBeneficiario(beneficiario);
    }

    // Atualiza um beneficiário existente
    @PutMapping("/{id}")
    public Beneficiario atualizarBeneficiario(@PathVariable Long id, @RequestBody Beneficiario novoBeneficiario) {
        return beneficiarioService.atualizarBeneficiario(id, novoBeneficiario);
    }

    // Exclui um beneficiário por ID
    @DeleteMapping("/{id}")
    public void excluirBeneficiario(@PathVariable Long id) {
        beneficiarioService.excluirBeneficiario(id);
    }
}
