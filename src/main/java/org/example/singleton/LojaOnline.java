package org.example.singleton;

public class LojaOnline {
    private static LojaOnline instancia;

    private LojaOnline() {
        // Construtor privado para evitar instância direta
    }

    public static LojaOnline obterInstancia() {
        if (instancia == null) {
            instancia = new LojaOnline();
        }
        return instancia;
    }


}
