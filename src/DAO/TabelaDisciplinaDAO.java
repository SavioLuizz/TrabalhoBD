package DAO;

import ConexaoBD.Conexao;
import Entity.TabelaAluno;
import Entity.TabelaDisciplina;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelaDisciplinaDAO {

    public void creatDisciplina(TabelaDisciplina tabelaDisciplina) {
        String sql = "INSERT INTO TABELA_DISCIPLINAS (NOME_DISCIPLINA) VALUES (?)";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tabelaDisciplina.getNomeDisciplina());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDisciplinas() {
        String sql = "SELECT * FROM TABELA_DISCIPLINAS";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                String nomeDisciplina = resultado.getString("nome_disciplina");
                System.out.println(nomeDisciplina);
            }
            ps.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDisciplina(int id){
        String sql = "SELECT * FROM TABELA_DISCIPLINAS WHERE ID_DISCIPLINA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                int idDisciplina = resultado.getInt("id_disciplina");
                String nomeDisciplina = resultado.getString("nome_disciplina");

                TabelaDisciplina tabelaDisciplina = new TabelaDisciplina(idDisciplina,nomeDisciplina);
                System.out.println(tabelaDisciplina);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDisciplina(int id, TabelaDisciplina tabelaDisciplina){
        String sql = "UPDATE TABELA_DISCIPLINAS SET NOME_DISCIPLINA = ? WHERE ID_DISCIPLINA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1,tabelaDisciplina.getNomeDisciplina());
            ps.setInt(2,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDisciplina (int id,TabelaDisciplina tabelaDisciplina){
        String sql = "DELETE FROM TABELA_DISCIPLINAS WHERE ID_DISCIPLINA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
