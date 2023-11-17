package org.example.factory;

public class FabricaEletronico implements FabricaProduto{
    @Override
    public Produto criarProduto() {
        return new ProdutoEletronico();
    }
}
