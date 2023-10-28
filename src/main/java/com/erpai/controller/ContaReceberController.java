package com.erpai.controller;

import com.erpai.domain.ContaReceber;
import com.erpai.service.ContaReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contas-receber")
public class ContaReceberController {

    @Autowired
    private ContaReceberService contaReceberService;

    // Retorna a lista de todas as contas a receber
    @GetMapping
    public List<ContaReceber> listarContasReceber() {
        return contaReceberService.listarContasReceber();
    }

    // Retorna uma conta a receber por ID
    @GetMapping("/{id}")
    public ContaReceber encontrarContaReceberPorId(@PathVariable Long id) {
        return contaReceberService.encontrarContaReceberPorId(id)
                .orElse(null); // Lida com o caso em que a conta a receber não existe
    }

    // Cria uma nova conta a receber
    @PostMapping
    public ContaReceber salvarContaReceber(@RequestBody ContaReceber contaReceber) {
        return contaReceberService.salvarContaReceber(contaReceber);
    }

    // Atualiza uma conta a receber existente
    @PutMapping("/{id}")
    public ContaReceber atualizarContaReceber(@PathVariable Long id, @RequestBody ContaReceber novaContaReceber) {
        return contaReceberService.atualizarContaReceber(id, novaContaReceber);
    }

    // Exclui uma conta a receber por ID
    @DeleteMapping("/{id}")
    public void excluirContaReceber(@PathVariable Long id) {
        contaReceberService.excluirContaReceber(id);
    }
}
