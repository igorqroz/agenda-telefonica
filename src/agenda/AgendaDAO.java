package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    public void salvar(Contato contato) {
        String sql = "INSERT INTO contato (nome, telefone, email, empresa, cargo, aniversario, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());

            if (contato instanceof ContatoProfissional) {
                ContatoProfissional pro = (ContatoProfissional) contato;
                stmt.setString(4, pro.getEmpresa());
                stmt.setString(5, pro.getCargo());

                stmt.setNull(6, Types.DATE);
                stmt.setNull(7, Types.VARCHAR);

            } else if (contato instanceof ContatoPessoal) {
                ContatoPessoal pes = (ContatoPessoal) contato;

                stmt.setNull(4, Types.VARCHAR);
                stmt.setNull(5, Types.VARCHAR);

                if (pes.getAniversario() != null) {
                    stmt.setDate(6, Date.valueOf(pes.getAniversario()));
                } else {
                    stmt.setNull(6, Types.DATE);
                }
                stmt.setString(7, pes.getEndereco());
            }

            stmt.execute();
            System.out.println("Contato salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public List<Contato> listarTodos() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato";

        try (Connection conn = ConexaoDB.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) { // ResultSet é a tabela que volta do banco

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");

                String empresa = rs.getString("empresa");

                if (empresa != null) {
                    String cargo = rs.getString("cargo");
                    lista.add(new ContatoProfissional(id, nome, telefone, email, empresa, cargo));
                } else {
                    Date dataSql = rs.getDate("aniversario");
                    LocalDate niver = (dataSql != null) ? dataSql.toLocalDate() : null;
                    String endereco = rs.getString("endereco");
                    lista.add(new ContatoPessoal(id, nome, telefone, email, niver, endereco));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    public void remover(int id) {
        String sql = "DELETE FROM contato WHERE id = ?";

        try (Connection conn = ConexaoDB.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Contato excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}
//