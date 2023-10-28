package com.erpai.controller;

import com.erpai.domain.TipoConta;
import com.erpai.service.TipoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tipos-conta")
public class TipoContaController {

    @Autowired
    private TipoContaService tipoContaService;

    // Retorna a lista de todos os tipos de conta
    @GetMapping
    public List<TipoConta> listarTiposConta() {
        return tipoContaService.listarTiposConta();
    }

    // Retorna um tipo de conta por ID
    @GetMapping("/{id}")
    public TipoConta encontrarTipoContaPorId(@PathVariable Long id) {
        return tipoContaService.encontrarTipoContaPorId(id)
                .orElse(null); // Lida com o caso em que o tipo de conta não existe
    }

    // Cria um novo tipo de conta
    @PostMapping
    public TipoConta salvarTipoConta(@RequestBody TipoConta tipoConta) {
        return tipoContaService.salvarTipoConta(tipoConta);
    }

    // Atualiza um tipo de conta existente
    @PutMapping("/{id}")
    public TipoConta atualizarTipoConta(@PathVariable Long id, @RequestBody TipoConta novoTipoConta) {
        return tipoContaService.atualizarTipoConta(id, novoTipoConta);
    }

    // Exclui um tipo de conta por ID
    @DeleteMapping("/{id}")
    public void excluirTipoConta(@PathVariable Long id) {
        tipoContaService.excluirTipoConta(id);
    }
}
