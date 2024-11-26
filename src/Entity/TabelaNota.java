package Entity;

import java.util.Date;

public class TabelaNota {
    private int idNota;
    private int idAluno;
    private int idDisciplina;
    private float nota;
    private Date dataAvaliacao;

    @Override
    public String toString() {
        return "TabelaNota{" +
                "idNota=" + idNota +
                ", idAluno=" + idAluno +
                ", idDisciplina=" + idDisciplina +
                ", nota=" + nota +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }

    public TabelaNota() {
    }

    public TabelaNota(int idNota, int idAluno, int idDisciplina, float nota, Date dataAvaliacao) {
        this.idNota = idNota;
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
    public java.sql.Date getDataAvaliac(){
        return new java.sql.Date(this.dataAvaliacao.getTime());
    }
}
