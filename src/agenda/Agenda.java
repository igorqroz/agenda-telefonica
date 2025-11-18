package agenda;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato novoContato) {
        this.contatos.add(novoContato);
        System.out.println("Contato de '" + novoContato.getNome() + "' foi adicionado.");
    }

    public void listarContatos() {
        System.out.println("\n--- LISTA DE CONTATOS ---");
        if (this.contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            for (Contato c : this.contatos) {
                c.exibir();
            }
        }
    }
}
