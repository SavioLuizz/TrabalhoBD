package Entity;

import java.util.Date;

public class TabelaAluno {
    private int id;
    private String nomeAluno;
    private Date dataNascimento;

    @Override
    public String toString() {
        return "TabelaAluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public TabelaAluno(String nomeAluno, Date dataNascimento) {
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
    }

    public TabelaAluno(int id, String nomeAluno, Date dataNascimento) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public java.sql.Date getDataNascim() {
        return new java.sql.Date(this.dataNascimento.getTime());
    }
}
