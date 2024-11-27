package Entity;

public class TabelaDisciplina {
    private int id;
    private String nomeDisciplina;

    @Override
    public String toString() {
        return "TabelaDisciplina{" +
                "id=" + id +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                '}';
    }

    public TabelaDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public TabelaDisciplina(int id, String nomeDisciplina) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
