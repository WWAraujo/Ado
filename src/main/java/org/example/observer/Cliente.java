package org.example.observer;

public class Cliente implements Observador{

    private String nome;

    public Cliente (String nome){
        this.nome = nome;
    }

    @Override
    public void receberNotificacao(String mensagem) {
        System.out.println(nome + ": " + mensagem);
    }
}
