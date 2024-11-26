package DAO;

import ConexaoBD.Conexao;
import Entity.TabelaAluno;
import Entity.TabelaProjeto;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TabelaAlunoDAO {

    public void creatAluno(TabelaAluno tabelaAluno) {
        String sql = "INSERT INTO TABELA_ALUNOS (NOME_ALUNO,DATA_NASCIMENTO) VALUES (?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tabelaAluno.getNomeAluno());
            ps.setDate(2, tabelaAluno.getDataNascim());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAlunos() {
        String sql = "SELECT * FROM TABELA_ALUNOS";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome_aluno");
                Date data = resultado.getDate("data_nascimento");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAluno(int id) {
        String sql = "SELECT * FROM TABELA_ALUNOS WHERE ID_ALUNO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                int idNome = resultado.getInt("id_nome");
                String nome = resultado.getString("nome_aluno");
                Date data = resultado.getDate("1");

                TabelaAluno tabelaAluno = new TabelaAluno(idNome, nome, data);
                System.out.println(tabelaAluno);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateNome(int id, TabelaAluno tabelaAluno) {
        String sql = "UPDATE TABELA_ALUNOS SET NOME_ALUNO = ? WHERE ID_ALUNO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tabelaAluno.getNomeAluno());
            ps.setInt(2, id);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteAluno(int id) {
        String sql = "DELETE FROM TABELA_ALUNOS WHERE ID_ALUNO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            ps.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

