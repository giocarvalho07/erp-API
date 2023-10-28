package com.erpai.controller;

import com.erpai.domain.Fornecedor;
import com.erpai.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> encontrarFornecedorPorId(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.encontrarFornecedorPorId(id);
        if (fornecedor.isPresent()) {
            return ResponseEntity.ok().body(fornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorService.salvarFornecedor(fornecedor);
        return ResponseEntity.ok().body(novoFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor novoFornecedor) {
        Fornecedor fornecedorAtualizado = fornecedorService.atualizarFornecedor(id, novoFornecedor);
        if (fornecedorAtualizado != null) {
            return ResponseEntity.ok().body(fornecedorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable Long id) {
        fornecedorService.excluirFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
