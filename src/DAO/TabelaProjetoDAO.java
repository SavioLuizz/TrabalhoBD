package DAO;

import ConexaoBD.Conexao;
import Entity.TabelaProjeto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelaProjetoDAO {

    public void createProjeto(TabelaProjeto tabelaProjeto) {

        String sql = "INSERT INTO TABELA_PROJETOS " +
                "(NOME_PROJETO,DESCRICAO_PROJETO,DATA_INICIOPROJETO, DATA_FIMPROJETO) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tabelaProjeto.getNomeProjeto());
            ps.setString(2, tabelaProjeto.getDescricaoProjeto());
            ps.setDate(3, tabelaProjeto.getDataInicioSql());
            ps.setDate(4, tabelaProjeto.getDataFimSql());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //GetAll
    public void getProjetos() {
        String sql = "SELECT * FROM TABELA_PROJETOS";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                TabelaProjeto projeto = TabelaProjeto.parseFromSql(resultado);
                System.out.println(projeto);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //GetOne
    public void getProjeto(int id) {
        String sql = "SELECT * FROM TABELA_PROJETOS WHERE ID_PROJETO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                TabelaProjeto projeto = TabelaProjeto.parseFromSql(resultado);
                System.out.println(projeto);
            }
            ps.close();
            resultado.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteProjeto(int id) {
        String sql = "DELETE FROM TABELA_PROJETOS WHERE ID_PROJETO = ?";
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

    public void updateProjeto(int id, TabelaProjeto tabelaProjeto) {
        String sql = "UPDATE TABELA_PROJETOS SET NOME_PROJETO = ?, DESCRICAO_PROJETO = ?," +
                "DATA_INICIOPROJETO = ?, DATA_FIMPROJETO = ? WHERE ID_PROJETO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tabelaProjeto.getNomeProjeto());
            ps.setString(2, tabelaProjeto.getDescricaoProjeto());
            ps.setDate(3, tabelaProjeto.getDataInicioSql());
            ps.setDate(4, tabelaProjeto.getDataFimSql());
            ps.setInt(5, id);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}


