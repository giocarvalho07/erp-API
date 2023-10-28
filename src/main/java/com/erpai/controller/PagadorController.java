package com.erpai.controller;

import com.erpai.domain.Pagador;
import com.erpai.service.PagadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pagadores")
public class PagadorController {

    @Autowired
    private PagadorService pagadorService;

    // Retorna a lista de todos os pagadores
    @GetMapping
    public List<Pagador> listarPagadores() {
        return pagadorService.listarPagadores();
    }

    // Retorna um pagador por ID
    @GetMapping("/{id}")
    public Pagador encontrarPagadorPorId(@PathVariable Long id) {
        return pagadorService.encontrarPagadorPorId(id)
                .orElse(null); // Lida com o caso em que o pagador não existe
    }

    // Cria um novo pagador
    @PostMapping
    public Pagador salvarPagador(@RequestBody Pagador pagador) {
        return pagadorService.salvarPagador(pagador);
    }

    // Atualiza um pagador existente
    @PutMapping("/{id}")
    public Pagador atualizarPagador(@PathVariable Long id, @RequestBody Pagador novoPagador) {
        return pagadorService.atualizarPagador(id, novoPagador);
    }

    // Exclui um pagador por ID
    @DeleteMapping("/{id}")
    public void excluirPagador(@PathVariable Long id) {
        pagadorService.excluirPagador(id);
    }
}
