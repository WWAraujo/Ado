package org.example.service;

import org.example.factory.Produto;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto produto) {
        itens.add(produto);
        System.out.println("Item adicionado ao carrinho: " + produto.getClass().getSimpleName());
    }

    public void exibirCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("Carrinho de compras:");
            for (Produto produto : itens) {
                System.out.println("- " + produto.getClass().getSimpleName());
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            // Supondo que a classe Produto tenha um método getPreco()
            total += produto.getPreco();
        }
        return total;
    }
}
