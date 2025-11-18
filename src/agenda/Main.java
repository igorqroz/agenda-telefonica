package agenda;

class Main {

    public static void main(String[] args) {
        Agenda minhaAgenda = new Agenda();

        System.out.println("--- Minha Agenda Telefônica ---");

        Contato c1 = new Contato("ana silva", "9999-1111");
        Contato c2 = new Contato("Beto Costa", "9888-2222");

        minhaAgenda.adicionarContato(c1);
        minhaAgenda.adicionarContato(c2);

        minhaAgenda.listarContatos();

    }
}
