package agenda;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        AgendaDAO dao = new AgendaDAO();

        ContatoPessoal c1 = new ContatoPessoal("Igor", "9999-1111", "igor@email.com", LocalDate.of(1998, 5, 11), "Rua A");

        ContatoProfissional c2 = new ContatoProfissional("Carlos", "8888-2222", "carlos@work.com", "Tech Solutions", "Dev Júnior");

        //System.out.println("--- SALVANDO NO BANCO ---");
        //dao.salvar(c1);
        //dao.salvar(c2);
        
//        int idParaDeletar = 8; 
//        
//        System.out.println("\n--- DELETANDO O ID " + idParaDeletar + " ---");
//        dao.remover(idParaDeletar);
        
        System.out.println("\n--- LISTANDO DO BANCO ---");
        for (Contato c : dao.listarTodos()) {
            System.out.println(c.getDetalhes());
        }
    }
}
