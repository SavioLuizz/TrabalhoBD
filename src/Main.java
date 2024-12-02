import DAO.*;
import Entity.*;

import java.util.Date;
import java.util.Scanner;

import DAO.*;
import Entity.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TabelaAlunoDAO alunoDAO = new TabelaAlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Professor");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do professor: ");
                    String nomeProfessor = scanner.nextLine();

                    // Criar e salvar professor
                    Professor professor = new Professor();
                    professor.setNomeProfessor(nomeProfessor);
                    professorDAO.createProfessor(professor);

                    System.out.println("Professor adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();

                    System.out.print("Digite a data de nascimento do aluno (dd/MM/yyyy): ");
                    String dataNascimento = scanner.nextLine();

                    try {
                        // Parse da data
                        Date data = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);

                        // Criar e salvar aluno
                        TabelaAluno aluno = new TabelaAluno(nomeAluno, data);
                        alunoDAO.creatAluno(aluno);

                        System.out.println("Aluno adicionado com sucesso!");
                    } catch (java.text.ParseException e) {
                        System.out.println("Erro ao processar a data. Certifique-se de usar o formato dd/MM/yyyy.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }


//    //TabelaAluno tabelaAluno = new TabelaAluno("Savio", new Date());
//
//
//    //TabelaDisciplina tabelaDisciplina = new TabelaDisciplina(1, "Banco de Dados");
//        tabelaDisciplina.setId(1);
//
//    TabelaNota tabelaNot = new TabelaNota();
//                tabelaNot.setNota(5.5F);
//
//
//    TabelaProjetoDAO projetoDAO = new TabelaProjetoDAO();
//    TabelaTarefaDAO tarefaDAO = new TabelaTarefaDAO();
//    TabelaAlunoDAO alunoDAO = new TabelaAlunoDAO();
//    TabelaDisciplinaDAO disciplinaDAO = new TabelaDisciplinaDAO();
//    ProfessorDAO professsorDAO = new ProfessorDAO();
//
//
//    //tarefaDAO.creatTarefa(tabelaTar);
//
//
//    //alunoDAO.creatAluno(tabelaAluno);
//    //alunoDAO.getAlunos();
//    //projetoDAO.createProjeto(tabelaProj);
//                professsorDAO.createProfessor(professor);
//                professsorDAO.getProfessores();
//
//    //disciplinaDAO.creatDisciplina(tabelaDisciplina);
//
//    //projetoDAO.getProjeto(1);
//    //projetoDAO.deleteProjeto(2);
//    //projetoDAO.getProjetos();
//    //projetoDAO.updateProjeto(1,new TabelaProjeto(1,"Projeto03","ccccc",new Date(),new Date()));
//    //projetoDAO.getProjeto(1);
}

