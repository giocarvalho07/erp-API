package com.erpai.controller;

import com.erpai.domain.TipoFornecedor;
import com.erpai.service.TipoFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tipo-fornecedores")
public class TipoFornecedorController {

    @Autowired
    private TipoFornecedorService tipoFornecedorService;

    @GetMapping
    public ResponseEntity<List<TipoFornecedor>> listarTiposFornecedor() {
        List<TipoFornecedor> tiposFornecedor = tipoFornecedorService.listarTiposFornecedor();
        return ResponseEntity.ok().body(tiposFornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFornecedor> encontrarTipoFornecedorPorId(@PathVariable Long id) {
        Optional<TipoFornecedor> tipoFornecedor = tipoFornecedorService.encontrarTipoFornecedorPorId(id);
        if (tipoFornecedor.isPresent()) {
            return ResponseEntity.ok().body(tipoFornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoFornecedor> salvarTipoFornecedor(@RequestBody TipoFornecedor tipoFornecedor) {
        TipoFornecedor novoTipoFornecedor = tipoFornecedorService.salvarTipoFornecedor(tipoFornecedor);
        return ResponseEntity.ok().body(novoTipoFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoFornecedor> atualizarTipoFornecedor(@PathVariable Long id, @RequestBody TipoFornecedor novoTipoFornecedor) {
        TipoFornecedor tipoFornecedorAtualizado = tipoFornecedorService.atualizarTipoFornecedor(id, novoTipoFornecedor);
        if (tipoFornecedorAtualizado != null) {
            return ResponseEntity.ok().body(tipoFornecedorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTipoFornecedor(@PathVariable Long id) {
        tipoFornecedorService.excluirTipoFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
