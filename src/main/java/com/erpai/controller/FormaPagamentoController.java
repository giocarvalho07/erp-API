package com.erpai.controller;

import com.erpai.domain.FormaPagamento;
import com.erpai.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    // Retorna a lista de todas as formas de pagamento
    @GetMapping
    public List<FormaPagamento> listarFormasPagamento() {
        return formaPagamentoService.listarFormasPagamento();
    }

    // Retorna uma forma de pagamento por ID
    @GetMapping("/{id}")
    public FormaPagamento encontrarFormaPagamentoPorId(@PathVariable Long id) {
        return formaPagamentoService.encontrarFormaPagamentoPorId(id)
                .orElse(null); // Lida com o caso em que a forma de pagamento não existe
    }

    // Cria uma nova forma de pagamento
    @PostMapping
    public FormaPagamento salvarFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.salvarFormaPagamento(formaPagamento);
    }

    // Atualiza uma forma de pagamento existente
    @PutMapping("/{id}")
    public FormaPagamento atualizarFormaPagamento(@PathVariable Long id, @RequestBody FormaPagamento novaFormaPagamento) {
        return formaPagamentoService.atualizarFormaPagamento(id, novaFormaPagamento);
    }

    // Exclui uma forma de pagamento por ID
    @DeleteMapping("/{id}")
    public void excluirFormaPagamento(@PathVariable Long id) {
        formaPagamentoService.excluirFormaPagamento(id);
    }
}
