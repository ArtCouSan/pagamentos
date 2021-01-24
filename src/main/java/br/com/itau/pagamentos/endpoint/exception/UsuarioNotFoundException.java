package br.com.itau.pagamentos.endpoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ID nao encontrado")
public class UsuarioNotFoundException extends Exception {
}
