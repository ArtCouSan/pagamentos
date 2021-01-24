package br.com.itau.pagamentos.endpoint.controller;

import br.com.itau.pagamentos.endpoint.dto.request.RequestVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.dto.response.ResponseVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.services.PagamentoBoletoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/boleto")
public class PagamentoBoletoController {

    private final PagamentoBoletoService pagamentoBoletoService;

    public PagamentoBoletoController(PagamentoBoletoService pagamentoBoletoService) {
        this.pagamentoBoletoService = pagamentoBoletoService;
    }

    @ApiOperation(value = "Verifica se o valor a ser pago eh recorrente, ou seja, valido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna se eh valido e mensagem"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "verificar-valor-pago")
    public ResponseEntity<ResponseVerificarValorPagamentoBoletoDTO> verificarValorPagamentoBoleto(@Valid @RequestBody RequestVerificarValorPagamentoBoletoDTO pagamentoBoletoVerificarValorDTO) {

        ResponseVerificarValorPagamentoBoletoDTO responseEhValido = this.pagamentoBoletoService.verificarValorBoleto(pagamentoBoletoVerificarValorDTO);

        return new ResponseEntity<>(responseEhValido, HttpStatus.OK);

    }

}
