package agenda;

public class ContatoProfissional extends Contato {

    private String empresa;
    private String cargo;

    public ContatoProfissional(int id, String nome, String telefone, String email, String empresa, String cargo) {
        super(id, nome, telefone, email);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public ContatoProfissional(String nome, String telefone, String email, String empresa, String cargo) {
        super(nome, telefone, email);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getDetalhes() {
        return "[Profissional] " + getNome() + " | " + cargo + " na " + empresa;
    }
}
