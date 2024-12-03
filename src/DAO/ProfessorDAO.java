package DAO;

import ConexaoBD.Conexao;
import Entity.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {
    public void createProfessor(Professor professor) {

        String sql = "INSERT INTO TABELA_PROFESSORES " +
                "(NOME_PROFESSOR) VALUES (?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, professor.getNomeProfessor());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //GetAll
    public void getProfessores(String nomeProfessor) {
        String sql = "SELECT * FROM TABELA_PROFESSORES";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Professor professor = Professor.parseFromSql(resultado);
                System.out.println(professor);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //GetOne
    public void getProfessor(int id) {
        String sql = "SELECT * FROM TABELA_PROFESSORES WHERE ID_PROFESSOR = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Professor professor = Professor.parseFromSql(resultado);
                System.out.println(professor);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteProfessor(int id) {
        String sql = "DELETE FROM TABELA_PROFESSORES WHERE ID_PROFESSOR = ?";
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

    public void updateProfessor(int id, Professor professor) {
        String sql = "UPDATE TABELA_PROFESSORES SET NOME_PROFESSOR = ? WHERE ID_PROFESSOR = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, professor.getNomeProfessor());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existeProfessor(String nome) {
        String sql = "SELECT COUNT(*) FROM TABELA_PROFESSORES WHERE NOME_PROFESSOR = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar professor: " + e.getMessage());
        }
        return false;
    }
}
