package com.erpai.controller;

import com.erpai.domain.Informativo;
import com.erpai.service.InformativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/informativos")
public class InformativoController {

    @Autowired
    private InformativoService informativoService;

    // Retorna a lista de todos os informativos
    @GetMapping
    public List<Informativo> listarInformativos() {
        return informativoService.listarInformativos();
    }

    // Retorna um informativo por ID
    @GetMapping("/{id}")
    public Informativo encontrarInformativoPorId(@PathVariable Long id) {
        return informativoService.encontrarInformativoPorId(id)
                .orElse(null); // Lida com o caso em que o informativo não existe
    }

    // Cria um novo informativo
    @PostMapping
    public Informativo salvarInformativo(@RequestBody Informativo informativo) {
        return informativoService.salvarInformativo(informativo);
    }

    // Atualiza um informativo existente
    @PutMapping("/{id}")
    public Informativo atualizarInformativo(@PathVariable Long id, @RequestBody Informativo novoInformativo) {
        return informativoService.atualizarInformativo(id, novoInformativo);
    }

    // Exclui um informativo por ID
    @DeleteMapping("/{id}")
    public void excluirInformativo(@PathVariable Long id) {
        informativoService.excluirInformativo(id);
    }
}
