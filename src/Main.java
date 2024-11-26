import DAO.TabelaAlunoDAO;
import DAO.TabelaDisciplinaDAO;
import DAO.TabelaProjetoDAO;
import DAO.TabelaTarefaDAO;
import Entity.TabelaAluno;
import Entity.TabelaDisciplina;
import Entity.TabelaProjeto;
import Entity.TabelaTarefa;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TabelaProjeto tabelaProj = new TabelaProjeto();
        tabelaProj.setNomeProjeto("Projeto04");
        tabelaProj.setDescricaoProjeto("Disciplina: ashdgajkshdg");
        tabelaProj.setDataInicioProj(new Date());
        tabelaProj.setDataFimProj(new Date());

        TabelaTarefa tabelaTar = new TabelaTarefa();
        tabelaTar.setDescricaoTarefa("olha olha olha");
        tabelaTar.setStatusTarefa("incompleto");
        tabelaTar.setIdProjeto(1);

        TabelaAluno tabelaAluno = new TabelaAluno();
        tabelaAluno.setNomeAluno("Savio");
        tabelaAluno.setDataNascimento(new Date());

        TabelaDisciplina tabelaDisciplina = new TabelaDisciplina();
        tabelaDisciplina.setNomeDisciplina("Banco de Dados");
        tabelaDisciplina.setId(1);



        TabelaProjetoDAO projetoDAO = new TabelaProjetoDAO();
        TabelaTarefaDAO tarefaDAO = new TabelaTarefaDAO();
        TabelaAlunoDAO alunoDAO = new TabelaAlunoDAO();
        TabelaDisciplinaDAO disciplinaDAO = new TabelaDisciplinaDAO();
        //tarefaDAO.creatTarefa(tabelaTar);
        //alunoDAO.creatAluno(tabelaAluno);
        //alunoDAO.getAlunos();
        //projetoDAO.createProjeto(tabelaProj);
        disciplinaDAO.creatDisciplina(tabelaDisciplina);

        //projetoDAO.getProjeto(1);
        //projetoDAO.deleteProjeto(2);
        //projetoDAO.getProjetos();
        //projetoDAO.updateProjeto(1,new TabelaProjeto(1,"Projeto03","ccccc",new Date(),new Date()));
        //projetoDAO.getProjeto(1);
    }
}