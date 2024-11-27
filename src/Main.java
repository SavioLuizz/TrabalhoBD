import DAO.TabelaAlunoDAO;
import DAO.TabelaDisciplinaDAO;
import DAO.TabelaProjetoDAO;
import DAO.TabelaTarefaDAO;
import Entity.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TabelaProjeto tabelaProj = new TabelaProjeto(
                "Projeto04",
                "Disciplina: ashdgajkshdg",
                new Date(),
                new Date()
        );

        TabelaTarefa tabelaTar = new TabelaTarefa(
                "olha olha olha",
                "incompleto",
                1
        );

        TabelaAluno tabelaAluno = new TabelaAluno("Savio", new Date());

        TabelaDisciplina tabelaDisciplina = new TabelaDisciplina(1,"Banco de Dados");
        tabelaDisciplina.setId(1);

        TabelaNota tabelaNot = new TabelaNota();
        tabelaNot.setNota(5.5F);


    TabelaProjetoDAO projetoDAO = new TabelaProjetoDAO();
    TabelaTarefaDAO tarefaDAO = new TabelaTarefaDAO();
    TabelaAlunoDAO alunoDAO = new TabelaAlunoDAO();
    TabelaDisciplinaDAO disciplinaDAO = new TabelaDisciplinaDAO();
        projetoDAO.getProjetos();

        //tarefaDAO.creatTarefa(tabelaTar);

}
//alunoDAO.creatAluno(tabelaAluno);
        //alunoDAO.getAlunos();
        //projetoDAO.createProjeto(tabelaProj);
        //disciplinaDAO.creatDisciplina(tabelaDisciplina);

        //projetoDAO.getProjeto(1);
        //projetoDAO.deleteProjeto(2);
        //projetoDAO.getProjetos();
        //projetoDAO.updateProjeto(1,new TabelaProjeto(1,"Projeto03","ccccc",new Date(),new Date()));
        //projetoDAO.getProjeto(1);
    }
}