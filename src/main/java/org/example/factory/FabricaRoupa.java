package org.example.factory;

public class FabricaRoupa implements FabricaProduto{
    @Override
    public Produto criarProduto() {
        return new ProdutoRoupa();
    }
}
