package org.example.strategy;

public class PagamentoCartao  implements FormaPagamentoStrategy {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Cartão.");
    }
}
