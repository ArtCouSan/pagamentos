package br.com.itau.pagamentos.endpoint.controller;

import br.com.itau.pagamentos.endpoint.dto.request.RequestVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.dto.response.ResponseVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.services.PagamentoBoletoService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PagamentoBoletoController.class)
public class PagamentoBoletoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagamentoBoletoService service;

    @Test
    public void valorValidoPagamentoBoleto() throws Exception {

        Gson gson = new Gson();

        RequestVerificarValorPagamentoBoletoDTO request = new RequestVerificarValorPagamentoBoletoDTO();
        request.setAgencia("0033");
        request.setConta("0033");
        request.setEntidade("0033");
        request.setValorAPagar(BigDecimal.TEN);

        ResponseVerificarValorPagamentoBoletoDTO response = new ResponseVerificarValorPagamentoBoletoDTO();
        response.setMensagem("Sucesso");
        response.setEhValido(true);

        when(service.verificarValorBoleto(request)).thenReturn(response);

        this.mockMvc.perform(post("/v1/boleto/verificar-valor-pago")
                .content(gson.toJson(request))
                .contentType("application/json")
        ).andExpect(status().isOk());
    }

}
