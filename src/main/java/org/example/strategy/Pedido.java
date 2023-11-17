package org.example.strategy;

public class Pedido {
    private FormaPagamento formaPagamento;

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void realizarPagamento(double valor) {
        formaPagamento.processarPagamento(valor);
    }
}
