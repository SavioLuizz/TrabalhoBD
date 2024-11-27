package DAO;

import ConexaoBD.Conexao;
import Entity.TabelaNota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TabelaNotasDAO {

    public void createNotas(TabelaNota tabelaNota) {

        String sql = "INSERT INTO TABELA_NOTAS (ID_NOTA, ID_ALUNO, ID_DISCIPLINA, NOTA, DATA_AVALIACAO)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, tabelaNota.getIdNota());
            ps.setInt(2, tabelaNota.getIdAluno());
            ps.setInt(3, tabelaNota.getIdDisciplina());
            ps.setFloat(4, tabelaNota.getNota());
            ps.setDate(5, tabelaNota.getDataAvaliac());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getNotas() {
        String sql = "SELECT * FROM TABELA_NOTAS";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int idNota = resultado.getInt("id_nota");
                int idAluno = resultado.getInt("id_aluno");
                int idDisciplina = resultado.getInt("id_disciplina");
                float nota = resultado.getFloat("nota");
                Date dataAvaliacao = resultado.getDate("data_avaliacao");
            }
            ps.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getNota(int id) {
        String sql = "SELECT * FROM TABELA_NOTAS WHERE ID_NOTA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {

                int idNota = resultado.getInt("id_nota");
                int idAluno = resultado.getInt("id_aluno");
                int idDisciplina = resultado.getInt("id_disciplina");
                float nota = resultado.getFloat("nota");
                Date dataAvaliacao = resultado.getDate("data_avaliacao");

            }
            ps.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateNotas(int id, TabelaNota tabelaNota){
        String sql = "UPDATE TABELA_NOTAS SET NOTA = ?, DATA_AVALIACAO = ? WHERE ID_NOTA = ?";
        PreparedStatement ps = null;

        try {
            ps=Conexao.getConexao().prepareStatement(sql);
            ps.setFloat(1,tabelaNota.getNota());
            ps.setDate(2,tabelaNota.getDataAvaliac());
            ps.setInt(3,id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNota(int id){
        String sql = "DELETE FROM TABELA_NOTAS WHERE ID_NOTA = ?";
        PreparedStatement ps = null;

        try {
            ps=Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
