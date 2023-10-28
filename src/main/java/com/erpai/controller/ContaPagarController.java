package com.erpai.controller;

import com.erpai.domain.ContaPagar;
import com.erpai.service.ContaPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contas-pagar")
public class ContaPagarController {

    @Autowired
    private ContaPagarService contaPagarService;

    // Retorna a lista de todas as contas a pagar
    @GetMapping
    public List<ContaPagar> listarContasPagar() {
        return contaPagarService.listarContasPagar();
    }

    // Retorna uma conta a pagar por ID
    @GetMapping("/{id}")
    public ContaPagar encontrarContaPagarPorId(@PathVariable Long id) {
        return contaPagarService.encontrarContaPagarPorId(id)
                .orElse(null); // Lida com o caso em que a conta a pagar não existe
    }

    // Cria uma nova conta a pagar
    @PostMapping
    public ContaPagar salvarContaPagar(@RequestBody ContaPagar contaPagar) {
        return contaPagarService.salvarContaPagar(contaPagar);
    }

    // Atualiza uma conta a pagar existente
    @PutMapping("/{id}")
    public ContaPagar atualizarContaPagar(@PathVariable Long id, @RequestBody ContaPagar novaContaPagar) {
        return contaPagarService.atualizarContaPagar(id, novaContaPagar);
    }

    // Exclui uma conta a pagar por ID
    @DeleteMapping("/{id}")
    public void excluirContaPagar(@PathVariable Long id) {
        contaPagarService.excluirContaPagar(id);
    }
}
