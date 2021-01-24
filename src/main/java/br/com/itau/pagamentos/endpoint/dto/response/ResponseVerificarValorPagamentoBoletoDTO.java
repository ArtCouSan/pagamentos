package br.com.itau.pagamentos.endpoint.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVerificarValorPagamentoBoletoDTO {

    private String mensagem;
    private Boolean ehValido;

}
