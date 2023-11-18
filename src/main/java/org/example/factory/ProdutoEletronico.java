package org.example.factory;


public class ProdutoEletronico extends FabricaProduto implements Produto{


    @Override
    public void exibirDetalhes() {
        System.out.println("Produto eletronico : " + nome + "\t Preço: R$"+preco);
    }

    @Override
    public double getPreco() {
        return 0;
    }
}
