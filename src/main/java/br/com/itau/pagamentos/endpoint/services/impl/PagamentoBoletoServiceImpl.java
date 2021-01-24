package br.com.itau.pagamentos.endpoint.services.impl;

import br.com.itau.pagamentos.endpoint.dto.request.RequestVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.dto.response.ResponseVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.model.PagamentoBoleto;
import br.com.itau.pagamentos.endpoint.repository.PagamentoBoletoRepository;
import br.com.itau.pagamentos.endpoint.services.PagamentoBoletoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PagamentoBoletoServiceImpl implements PagamentoBoletoService {

    PagamentoBoletoRepository pagamentoBoletoRepository;

    public PagamentoBoletoServiceImpl(PagamentoBoletoRepository pagamentoBoletoRepository) {
        this.pagamentoBoletoRepository = pagamentoBoletoRepository;
    }

    @Override
    public ResponseVerificarValorPagamentoBoletoDTO verificarValorBoleto(RequestVerificarValorPagamentoBoletoDTO pagamentoBoletoVerificarValorDTO) {

        ResponseVerificarValorPagamentoBoletoDTO response = new ResponseVerificarValorPagamentoBoletoDTO();

        String banco = pagamentoBoletoVerificarValorDTO.getEntidade();
        String agencia = pagamentoBoletoVerificarValorDTO.getAgencia();
        String conta = pagamentoBoletoVerificarValorDTO.getConta();
        String id = banco.concat(agencia).concat(conta);

        Optional<PagamentoBoleto> pagamentoBoleto = pagamentoBoletoRepository.findById(id);

        if (pagamentoBoleto.isPresent()) {

            BigDecimal valorMaximo = pagamentoBoleto.get().getValorMaximoParaPagamento();
            BigDecimal valorVerificado = pagamentoBoletoVerificarValorDTO.getValorAPagar();

            if (valorVerificado.compareTo(valorMaximo) < 1) {

                response.setEhValido(Boolean.TRUE);
                response.setMensagem("Valor dentro do limite");

            } else {

                response.setEhValido(Boolean.FALSE);
                response.setMensagem("Valor maior que o limite");

            }

            return response;

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID: ".concat(id).concat(" nao encontrado."));

        }

    }

}
