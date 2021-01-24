package br.com.itau.pagamentos.endpoint.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVerificarValorPagamentoBoletoDTO {

    @NotBlank(message = "Agencia eh obrigatorio")
    private String agencia;

    @NotBlank(message = "Conta eh obrigatorio")
    private String conta;

    @NotBlank(message = "Entidade eh obrigatorio")
    private String entidade;

    @DecimalMin(value = "0.1", inclusive = false)
    @Digits(integer=10, fraction=2)
    private BigDecimal valorAPagar;

}
