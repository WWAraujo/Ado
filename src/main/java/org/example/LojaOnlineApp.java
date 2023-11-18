package org.example;

import org.example.facade.LojaFacade;
import org.example.factory.*;
import org.example.strategy.PagamentoBoleto;
import org.example.strategy.PagamentoCartao;

import java.util.Scanner;

public class LojaOnlineApp {
    private static LojaFacade lojaFacade = new LojaFacade();
    private static String nome;

    public static void main(String[] args) {
        inicializarLoja();
        exibirMenuPrincipal();
    }

    private static void inicializarLoja() {
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

    private static void exibirMenuPrincipal() {
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

    private static void exibirSubMenuAdicionarAoCarrinho(Scanner scanner) {
        lojaFacade.exibirProdutos();
        System.out.print("Escolha o número do produto para adicionar ao carrinho: ");
        int indiceProduto = scanner.nextInt();
        Produto produtoSelecionado = lojaFacade.obterProdutoPorIndice(indiceProduto);
        if (produtoSelecionado != null) {
            lojaFacade.adicionarItemAoCarrinho(produtoSelecionado);
        }
    }

    private static void exibirSubMenuEscolherFormaPagamento(Scanner scanner) {
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
}
