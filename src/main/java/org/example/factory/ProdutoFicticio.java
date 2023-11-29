package org.example.factory;

import org.example.factory.FabricaProduto;
import org.example.factory.Produto;

public class ProdutoFicticio extends FabricaProduto implements Produto {

    public ProdutoFicticio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Produto: " + nome + ", Preço: R$" + preco);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
