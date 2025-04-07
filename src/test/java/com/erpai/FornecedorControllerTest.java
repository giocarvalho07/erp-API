package com.erpai;

        import com.erpai.controller.FornecedorController;
        import com.erpai.domain.Fornecedor;
        import com.erpai.service.FornecedorService;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.junit.jupiter.MockitoExtension;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;

        import java.util.Arrays;
        import java.util.List;
        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FornecedorControllerTest {

    @InjectMocks
    private FornecedorController fornecedorController;

    @Mock
    private FornecedorService fornecedorService;

    @Test
    void listarFornecedores_deveRetornarListaNaoVazia() {
        // Arrange
        Fornecedor fornecedor1 = new Fornecedor(1L, "Fornecedor A", "12345678901", "contato@fornecedora.com");
        Fornecedor fornecedor2 = new Fornecedor(2L, "Fornecedor B", "98765432109", "vendas@fornecedorb.com");
        List<Fornecedor> fornecedoresEsperados = Arrays.asList(fornecedor1, fornecedor2);
        when(fornecedorService.listarFornecedores()).thenReturn(fornecedoresEsperados);

        // Act
        ResponseEntity<List<Fornecedor>> response = fornecedorController.listarFornecedores();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(fornecedorService, times(1)).listarFornecedores();
    }

    @Test
    void encontrarFornecedorPorId_deveRetornarFornecedorExistente() {
        // Arrange
        Long idProcurado = 1L;
        Fornecedor fornecedorEsperado = new Fornecedor(idProcurado, "Fornecedor C", "11223344556", "info@fornecedorc.com");
        when(fornecedorService.encontrarFornecedorPorId(idProcurado)).thenReturn(Optional.of(fornecedorEsperado));

        // Act
        ResponseEntity<Fornecedor> response = fornecedorController.encontrarFornecedorPorId(idProcurado);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(fornecedorEsperado.getId(), response.getBody().getId());
        verify(fornecedorService, times(1)).encontrarFornecedorPorId(idProcurado);
    }
}