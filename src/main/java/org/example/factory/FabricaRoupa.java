package org.example.factory;

public class FabricaRoupa implements IFabricaProduto {
    @Override
    public Produto criarProduto() {
        return new ProdutoRoupa();
    }
}
