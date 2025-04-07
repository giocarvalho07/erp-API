package com.erpai;

        import com.erpai.controller.TipoContaController;
        import com.erpai.domain.TipoConta;
        import com.erpai.service.TipoContaService;
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
public class TipoContaControllerTest {

    @InjectMocks
    private TipoContaController tipoContaController;

    @Mock
    private TipoContaService tipoContaService;


    @Test
    void encontrarTipoContaPorId_deveRetornarNullQuandoNaoExistente() {
        // Arrange
        Long idProcurado = 99L;

        when(tipoContaService.encontrarTipoContaPorId(idProcurado)).thenReturn(Optional.empty());

        // Act
        TipoConta tipoContaRetornado = tipoContaController.encontrarTipoContaPorId(idProcurado);

        // Assert
        assertNull(tipoContaRetornado);
        verify(tipoContaService, times(1)).encontrarTipoContaPorId(idProcurado);
    }


    @Test
    void excluirTipoConta_deveChamarServicoDeExclusao() {
        // Arrange
        Long idParaExcluir = 1L;

        // Act
        tipoContaController.excluirTipoConta(idParaExcluir);

        // Assert
        verify(tipoContaService, times(1)).excluirTipoConta(idParaExcluir);
    }
}