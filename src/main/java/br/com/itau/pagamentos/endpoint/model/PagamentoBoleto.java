package br.com.itau.pagamentos.endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection  = "pagamento-boleto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoBoleto {

    @Id
    private String _id;
    private BigDecimal valorMaximoParaPagamento;

}
