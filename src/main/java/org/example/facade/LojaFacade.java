package org.example.facade;

import org.example.factory.Produto;
import org.example.service.Carrinho;
import org.example.strategy.FormaPagamentoStrategy;

import java.util.ArrayList;
import java.util.List;

public class LojaFacade {
    private List<Produto> produtos;
    private Carrinho carrinho;
    private FormaPagamentoStrategy formaPagamento;

    public LojaFacade() {
        produtos = new ArrayList<>();
        carrinho = new Carrinho();
    }

    public Produto obterProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            return produtos.get(indice);
        } else {
            System.out.println("Índice de produto inválido.");
            return null;
        }
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void exibirProdutos() {
        System.out.println("Produtos Disponíveis:");
        int n = 0;
        for (Produto produto : produtos) {
            System.out.print(n+"º "); produto.exibirDetalhes();
            n++;
        }
    }

    public void adicionarItemAoCarrinho(Produto produto) {
        carrinho.adicionarItem(produto);
    }

    public void exibirCarrinho() {
        carrinho.exibirCarrinho();
    }

    public void definirFormaPagamento(FormaPagamentoStrategy formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void realizarPagamento() {
        double total = carrinho.calcularTotal();
        formaPagamento.processarPagamento(total);
    }
}
