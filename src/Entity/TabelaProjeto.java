package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TabelaProjeto {
    private int id;
    private String nomeProjeto;
    private String descricaoProjeto;
    private Date dataInicioProj;
    private Date  dataFimProj;

    @Override
    public String toString() {
        return "TabelaProjeto{" +
                "id=" + id +
                ", nomeProjeto='" + nomeProjeto + '\'' +
                ", descricaoProjeto='" + descricaoProjeto + '\'' +
                ", dataInicioProj=" + dataInicioProj +
                ", dataFimProj=" + dataFimProj +
                '}';
    }

    public TabelaProjeto(String nomeProjeto, String descricaoProjeto, Date dataInicioProj, Date dataFimProj) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.dataInicioProj = dataInicioProj;
        this.dataFimProj = dataFimProj;
    }

    public TabelaProjeto(int id, String nomeProjeto, String descricaoProjeto, Date dataInicioProj, Date dataFimProj) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.dataInicioProj = dataInicioProj;
        this.dataFimProj = dataFimProj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public Date getDataInicioProj() {
        return dataInicioProj;
    }

    public void setDataInicioProj(Date dataInicioProj) {
        this.dataInicioProj = dataInicioProj;
    }

    public Date getDataFimProj() {
        return dataFimProj;
    }

    public void setDataFimProj(Date dataFimProj) {
        this.dataFimProj = dataFimProj;
    }

    public java.sql.Date getDataInicioSql(){
        return new java.sql.Date(this.dataInicioProj.getTime());
    }
    public java.sql.Date getDataFimSql(){
        return new java.sql.Date(this.dataFimProj.getTime());
    }

    public static TabelaProjeto parseFromSql(ResultSet resultado) {
        try {
            int id = resultado.getInt("id_projeto");
            String nome = resultado.getString("nome_Projeto");
            String decricao = resultado.getString("Descricao_Projeto");
            Date dataInicio = resultado.getDate("Data_inicioProjeto");
            Date dataFim = resultado.getDate("Data_fimProjeto");

            return new TabelaProjeto(id, nome, decricao, dataInicio, dataFim);
        } catch (SQLException e) {
            System.out.println("Error on parse from SQL");
            throw new RuntimeException(e);
        }
    }
}
