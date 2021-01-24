package br.com.itau.pagamentos.endpoint.services;

import br.com.itau.pagamentos.endpoint.dto.request.RequestVerificarValorPagamentoBoletoDTO;
import br.com.itau.pagamentos.endpoint.dto.response.ResponseVerificarValorPagamentoBoletoDTO;

public interface PagamentoBoletoService {

    public ResponseVerificarValorPagamentoBoletoDTO verificarValorBoleto(RequestVerificarValorPagamentoBoletoDTO pagamentoBoletoVerificarValorDTO);

}
