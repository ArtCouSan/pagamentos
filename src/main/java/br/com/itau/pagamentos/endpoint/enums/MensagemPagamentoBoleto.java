package br.com.itau.pagamentos.endpoint.enums;

public enum MensagemPagamentoBoleto {

    PAGAMENTO_VALIDO("Valor dentro do limite"),
    PAGAMENTO_INVALIDO("Valor maior que o limite");

    private String descricao;

    MensagemPagamentoBoleto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
