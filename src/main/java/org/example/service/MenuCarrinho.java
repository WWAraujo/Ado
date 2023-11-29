package org.example.service;

import org.example.facade.LojaFacade;
import org.example.factory.Produto;
import org.example.factory.ProdutoEletronico;
import org.example.factory.ProdutoRoupa;
import org.example.strategy.PagamentoBoleto;
import org.example.strategy.PagamentoCartao;

import java.util.Scanner;

public class MenuCarrinho {

    private LojaFacade lojaFacade = new LojaFacade();
    private String nome;


    public void exibirMenuPrincipal() {
        inicializarLoja();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("Bem vindo! Qual seu nome?");
        nome = scanner.next();


        do {
            System.out.println("### Menu Principal ###");
            System.out.println("1. Visualizar Produtos");
            System.out.println("2. Adicionar Item ao Carrinho");
            System.out.println("3. Exibir Carrinho");
            System.out.println("4. Escolher Forma de Pagamento");
            System.out.println("5. Realizar Pagamento");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    lojaFacade.exibirProdutos();
                    break;
                case 2:
                    exibirSubMenuAdicionarAoCarrinho(scanner);
                    break;
                case 3:
                    lojaFacade.exibirCarrinho();
                    break;
                case 4:
                    exibirSubMenuEscolherFormaPagamento(scanner);
                    break;
                case 5:
                    lojaFacade.realizarPagamento();
                    break;
                case 6:
                    System.out.println("Saindo da aplicação. Até mais "+nome+"!");
                    break;
                default:
                    System.out.println("Opção inválida "+nome+". Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private void exibirSubMenuAdicionarAoCarrinho(Scanner scanner) {
        lojaFacade.exibirProdutos();
        System.out.print("Escolha o número do produto para adicionar ao carrinho: ");
        int indiceProduto = scanner.nextInt();
        Produto produtoSelecionado = lojaFacade.obterProdutoPorIndice(indiceProduto);
        if (produtoSelecionado != null) {
            lojaFacade.adicionarItemAoCarrinho(produtoSelecionado);
        }
    }

    private void exibirSubMenuEscolherFormaPagamento(Scanner scanner) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão");
        System.out.println("2. Boleto");
        int opcaoPagamento = scanner.nextInt();

        switch (opcaoPagamento) {
            case 1:
                lojaFacade.definirFormaPagamento(new PagamentoCartao());
                break;
            case 2:
                lojaFacade.definirFormaPagamento(new PagamentoBoleto());
                break;
            default:
                System.out.println("Opção inválida. Forma de pagamento não definida.");
        }
    }


    private void inicializarLoja() {

        // Criar instâncias de produtos fictícios
        Produto produto = new ProdutoEletronico().setNome("Smartphone").setPreco(999.99).build();

        // Adicionar produtos à loja e à lojaFacade
        lojaFacade.adicionarProduto(produto);

        //Populando mais dados
        lojaFacade.adicionarProduto(new ProdutoEletronico().setNome("Laptop").setPreco(1499.99).build());
        lojaFacade.adicionarProduto(new ProdutoEletronico().setNome("Mouse").setPreco(39.99).build());
        lojaFacade.adicionarProduto(new ProdutoEletronico().setNome("Fone de Ouvido").setPreco(89.99).build());
        lojaFacade.adicionarProduto(new ProdutoRoupa().setNome("Camiseta").setPreco(29.99).build());
        lojaFacade.adicionarProduto(new ProdutoRoupa().setNome("Calsa Moleto").setPreco(89.99).build());
        lojaFacade.adicionarProduto(new ProdutoRoupa().setNome("Short").setPreco(49.99).build());
    }
}
