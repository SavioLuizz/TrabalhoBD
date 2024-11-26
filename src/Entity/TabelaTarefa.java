package Entity;

public class TabelaTarefa {

    private int id;
    private String descricaoTarefa;
    private String statusTarefa;
    private int idProjeto;

    public TabelaTarefa(){}

    @Override
    public String toString() {
        return "TabelaTarefa{" +
                "id=" + id +
                ", descricaoTarefa='" + descricaoTarefa + '\'' +
                ", statusTarefa='" + statusTarefa + '\'' +
                ", idProjeto=" + idProjeto +
                '}';
    }

    public TabelaTarefa(int id, String descricaoTarefa, String statusTarefa, int idProjeto) {
        this.id = id;
        this.descricaoTarefa = descricaoTarefa;
        this.statusTarefa = statusTarefa;
        this.idProjeto = idProjeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }
}
