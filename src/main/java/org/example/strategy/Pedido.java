package org.example.strategy;

public class Pedido {
    private FormaPagamentoStrategy formaPagamentoStrategy;

    public void setFormaPagamento(FormaPagamentoStrategy formaPagamentoStrategy) {
        this.formaPagamentoStrategy = formaPagamentoStrategy;
    }

    public void realizarPagamento(double valor) {
        formaPagamentoStrategy.processarPagamento(valor);
    }
}
