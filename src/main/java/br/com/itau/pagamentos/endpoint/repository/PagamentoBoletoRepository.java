package br.com.itau.pagamentos.endpoint.repository;

import br.com.itau.pagamentos.endpoint.model.PagamentoBoleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagamentoBoletoRepository extends MongoRepository<PagamentoBoleto, String> {
}
