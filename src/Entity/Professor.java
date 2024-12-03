package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor {
    private int id;
    private String nomeProfessor;


    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome_professor='" + nomeProfessor + '\'' +
                '}';
    }

    public Professor(int id, String nomeProfessor) {
        this.id = id;
        this.nomeProfessor = nomeProfessor;
    }

    public Professor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public static Professor parseFromSql(ResultSet resultado) {
        try {
            int id = resultado.getInt("id_professor");
            String nome = resultado.getString("nome_professor");


            return new Professor(id, nome);

        } catch (SQLException e) {
            System.out.println("Error on parse from SQL");
            throw new RuntimeException(e);
        }
    }
}
