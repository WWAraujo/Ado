package org.example.factory;

public class FabricaEletronico implements IFabricaProduto {
    @Override
    public Produto criarProduto() {
        return new ProdutoEletronico();
    }
}
