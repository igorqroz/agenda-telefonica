package agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContatoPessoal extends Contato {

    private LocalDate aniversario;
    private String endereco;

    public ContatoPessoal(int id, String nome, String telefone, String email, LocalDate aniversario, String endereco) {
        super(id, nome, telefone, email);
        this.aniversario = aniversario;
        this.endereco = endereco;
    }

    public ContatoPessoal(String nome, String telefone, String email, LocalDate aniversario, String endereco) {
        super(nome, telefone, email);
        this.aniversario = aniversario;
        this.endereco = endereco;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getDetalhes() {
        String dataBonita = (aniversario != null) ? aniversario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Sem data";
        return "[Pessoal] " + getNome() + " | Niver: " + dataBonita;
    }
}
