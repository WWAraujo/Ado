package org.example.factory;

public class ProdutoRoupa extends FabricaProduto implements Produto{
    @Override
    public void exibirDetalhes() {
        System.out.println("Produto roupa");
    }

    @Override
    public double getPreco() {
        return 0;
    }
}
