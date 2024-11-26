package DAO;

import ConexaoBD.Conexao;
import Entity.TabelaProjeto;
import Entity.TabelaTarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TabelaTarefaDAO {

    public void creatTarefa(TabelaTarefa tabelaTarefa) {

        String sql = "INSERT INTO TABELA_TAREFAS (DESCRICAO_TAREFA,STATUS_TAREFA,ID_PROJETO)" +
                "VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tabelaTarefa.getDescricaoTarefa());
            ps.setString(2, tabelaTarefa.getStatusTarefa());
            ps.setInt(3, tabelaTarefa.getIdProjeto());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //GetAll
    public void getTarefas() {
        String sql = "SELECT * FROM TABELA_TAREFAS";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                String descricao = resultado.getString("Descricao_Tarefa");
                System.out.println(descricao);
            }
            ps.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //GetOne
    public void getTarefa(int id) {
        String sql = "SELECT * FROM TABELA_TAREFAS WHERE ID_TAREFA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                int idTarefa = resultado.getInt("id_tarefa");
                String descricao = resultado.getString("Descricao_Tarefa");
                String status = resultado.getString("Status_Tarefa");
                int idProjeto = resultado.getInt("id_projeto");


                TabelaTarefa tabelaTarefa = new TabelaTarefa(idTarefa, descricao, status, idProjeto);
                System.out.print(tabelaTarefa);
            }
            ps.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTarefa (int id, TabelaTarefa tabelaTarefa){
        String sql = "UPDATE TABELA_TAREFAS SET DESCRICAO_TAREFA = ?, STATUS_TAREFA = ? WHERE ID_TAREFA = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tabelaTarefa.getDescricaoTarefa());
            ps.setString(2, tabelaTarefa.getStatusTarefa());
            ps.setInt(3, id);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTarefa(int id){
        String sql = "DELETE FROM TABELA_TAREFAS WHERE ID_TAREFA = ?";
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
