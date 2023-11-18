package org.example.strategy;

public class PagamentoBoleto  implements FormaPagamentoStrategy {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Boleto.");
    }
}
