package br.com.itau.pagamentos.endpoint.services;

import br.com.itau.pagamentos.endpoint.dto.request.RequestVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.dto.response.ResponseVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.enums.MensagemPagamentoBoleto;
import br.com.itau.pagamentos.endpoint.model.PagamentoBoleto;
import br.com.itau.pagamentos.endpoint.repository.PagamentoBoletoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@WebMvcTest(PagamentoBoletoService.class)
public class PagamentoBoletoServiceTest {

    @Autowired
    private PagamentoBoletoService service;

    @MockBean
    private PagamentoBoletoRepository repository;

    @Test
    public void valorValidoPagamentoBoleto()  {

        RequestVerificarValorPagamentoBoletoDTO request = new RequestVerificarValorPagamentoBoletoDTO();
        request.setAgencia("0033");
        request.setConta("0033");
        request.setEntidade("0033");
        request.setValorAPagar(BigDecimal.TEN);

        String banco = request.getEntidade();
        String agencia = request.getAgencia();
        String conta = request.getConta();
        String id = banco.concat(agencia).concat(conta);

        PagamentoBoleto pagamentoMock = new PagamentoBoleto();
        pagamentoMock.set_id(id);
        pagamentoMock.setValorMaximoParaPagamento(BigDecimal.TEN);

        Optional<PagamentoBoleto> pagamentoBoleto = Optional.of(pagamentoMock);

        ResponseVerificarValorPagamentoBoletoDTO response = new ResponseVerificarValorPagamentoBoletoDTO();
        response.setMensagem(MensagemPagamentoBoleto.PAGAMENTO_VALIDO.getDescricao());
        response.setEhValido(true);

        when(repository.findById(id)).thenReturn(pagamentoBoleto);

        assertThat(service.verificarValorBoleto(request)).isEqualTo(response);

    }

    @Test
    public void valorInvalidoPagamentoBoleto()  {

        RequestVerificarValorPagamentoBoletoDTO request = new RequestVerificarValorPagamentoBoletoDTO();
        request.setAgencia("0033");
        request.setConta("0033");
        request.setEntidade("0033");
        request.setValorAPagar(BigDecimal.TEN);

        String banco = request.getEntidade();
        String agencia = request.getAgencia();
        String conta = request.getConta();
        String id = banco.concat(agencia).concat(conta);

        PagamentoBoleto pagamentoMock = new PagamentoBoleto();
        pagamentoMock.set_id(id);
        pagamentoMock.setValorMaximoParaPagamento(BigDecimal.ONE);

        Optional<PagamentoBoleto> pagamentoBoleto = Optional.of(pagamentoMock);

        ResponseVerificarValorPagamentoBoletoDTO response = new ResponseVerificarValorPagamentoBoletoDTO();
        response.setMensagem(MensagemPagamentoBoleto.PAGAMENTO_INVALIDO.getDescricao());
        response.setEhValido(false);

        when(repository.findById(id)).thenReturn(pagamentoBoleto);

        assertThat(service.verificarValorBoleto(request)).isEqualTo(response);

    }

    @Test
    public void usuarioNaoEncontrado()  {

        RequestVerificarValorPagamentoBoletoDTO request = new RequestVerificarValorPagamentoBoletoDTO();
        request.setAgencia("0033");
        request.setConta("0033");
        request.setEntidade("0033");
        request.setValorAPagar(BigDecimal.TEN);

        String banco = request.getEntidade();
        String agencia = request.getAgencia();
        String conta = request.getConta();
        String id = banco.concat(agencia).concat(conta);

        Optional<PagamentoBoleto> pagamentoBoleto = Optional.ofNullable(null);

        ResponseVerificarValorPagamentoBoletoDTO response = new ResponseVerificarValorPagamentoBoletoDTO();
        response.setMensagem(MensagemPagamentoBoleto.PAGAMENTO_INVALIDO.getDescricao());
        response.setEhValido(false);

        when(repository.findById(id)).thenReturn(pagamentoBoleto);

        assertThrows(Exception.class, () -> service.verificarValorBoleto(request));

    }

}
