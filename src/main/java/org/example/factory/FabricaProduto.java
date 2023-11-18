package org.example.factory;

import org.example.service.ProdutoFicticio;

public class FabricaProduto {
    protected String nome;
    protected double preco;

    public FabricaProduto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FabricaProduto setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Produto build() {
        // Aqui você pode adicionar lógica para criar instâncias de produtos
        // com base nos atributos configurados no builder.
        return new ProdutoFicticio(nome, preco);
    }
}
