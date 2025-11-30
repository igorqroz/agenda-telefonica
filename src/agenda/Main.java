package agenda;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AgendaDAO dao = new AgendaDAO();

        //Salva
        System.out.println("--- 1. SALVANDO NOVOS CONTATOS ---");

        ContatoPessoal c1 = new ContatoPessoal("Igor Queiroz", "(85) 99999-1111", "igor@email.com", LocalDate.of(2000, 05, 20), "Rua da Programação, 100");
        ContatoProfissional c2 = new ContatoProfissional("David Lima", "(85) 98888-2222", "david@tech.com", "Dev Team Soft", "Desenvolvedor Java");

        dao.salvar(c1);
        dao.salvar(c2);

        System.out.println(); // Pula linha

        //Listar
        System.out.println("--- 2. LISTANDO TUDO (OLHE OS IDs AQUI!) ---");

        List<Contato> todos = dao.listarTodos();
        for (Contato c : todos) {
            System.out.println("ID: " + c.getId() + " | " + c.getDetalhes());
        }
        System.out.println();

        //editar
        int idParaEditar = 1;

        System.out.println("--- 3. ATUALIZANDO O ID " + idParaEditar + " ---");

        ContatoPessoal contatoEditado = new ContatoPessoal(
                idParaEditar,
                "Maria Souza (EDITADO)",
                "0000-0000",
                "maria.nova@email.com",
                LocalDate.of(1995, 3, 10),
                "Casa Nova"
        );

        dao.atualizar(contatoEditado);

        // Confere se mudou
        System.out.println(">> Verificando mudança:");
        for (Contato c : dao.listarTodos()) {
            if (c.getId() == idParaEditar) {
                System.out.println(c.getDetalhes());
            }
        }
        System.out.println();

        //buscar
        String termo = "Tech";
        System.out.println("--- 4. BUSCANDO POR: '" + termo + "' ---");

        List<Contato> resultados = dao.buscarPorNome(termo);
        if (resultados.isEmpty()) {
            System.out.println("Ninguém encontrado.");
        } else {
            for (Contato c : resultados) {
                System.out.println("Achou: " + c.getDetalhes());
            }
        }
        System.out.println();

        //delete
        int idParaRemover = 1;

        System.out.println("--- 5. REMOVENDO O ID " + idParaRemover + " ---");
        dao.remover(idParaRemover);

        System.out.println(">> Lista Final:");
        for (Contato c : dao.listarTodos()) {
            System.out.println("ID: " + c.getId() + " | " + c.getDetalhes());
        }
    }
}
