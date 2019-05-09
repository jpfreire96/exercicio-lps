/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.JfrmMenu;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jpfreire
 */
public class SchoolProject {

    Exporta exporta = new Exporta();
    Importa importa = new Importa();
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

    public SchoolProject() {
        this.alunos = importa.importAluno();
        this.cursos = importa.importCurso();
    }

    public static void main(String[] args) {
        JfrmMenu menu = new JfrmMenu();
        menu.setVisible(true);
    }

    public Aluno findAluno(String nome) {
        int lenght = this.alunos.size();
        Aluno escolhido = new Aluno();
        for (int i = 0; i < lenght; i++) {
            Aluno aluno = alunos.get(i);
            if (aluno.getNome().equals(nome)) {
                escolhido = aluno;
            }
        }
        return escolhido;
    }

    public Curso findCurso(String nome) {
        int lenght = this.cursos.size();
        Curso escolhido = new Curso();
        for (int i = 0; i < lenght; i++) {
            Curso curso = cursos.get(i);
            if (curso.getNome().equals(nome)) {
                escolhido = curso;
            }
        }
        return escolhido;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.setCursos(cursos);
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public ArrayList<Matricula> getMatriculas() {
        this.matriculas = importa.importMatricula();
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
        exporta.exportMatriculaSubstitui(matriculas);
    }

    public void setMatriculasData(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
        String response = exporta.exportMatriculaSubstitui(matriculas);
        if (response == "success") {
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        }

    }

    public void setAluno(Aluno aluno) {
        Aluno temp = this.findAluno(aluno.getNome());
        if (!temp.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Aluno " + aluno.getNome() + " já está cadastrado!");
        } else {
            this.alunos.add(aluno);
            String s = exporta.exportAluno(this.alunos);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        }
    }

    public void setMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
        String s = exporta.exportMatricula(this.matriculas);
        JOptionPane.showMessageDialog(null, "Matricula cadastrado com sucesso!");
    }

    public void setCurso(Curso curso) {
        Curso temp = this.findCurso(curso.getNome());
        if (!temp.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Curso " + curso.getNome() + " já está cadastrado!");
        } else {
            this.cursos.add(curso);
            String s = exporta.exportCurso(this.cursos);
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
        }
    }

    public String[] getNomeAlunos() {
        this.alunos = importa.importAluno();
        int lenght = this.alunos.size();
        String[] nomeAluno = new String[lenght];
        for (int i = 0; i < lenght; i++) {
            nomeAluno[i] = this.alunos.get(i).getNome();
        }
        return nomeAluno;
    }

    public String[] getNomeCursos() {
        System.out.println("Deu");
        this.cursos = importa.importCurso();
        int lenght = this.cursos.size();
        String[] nomeCurso = new String[lenght];
        for (int i = 0; i < lenght; i++) {
            nomeCurso[i] = this.cursos.get(i).getNome();
        }
        return nomeCurso;
    }
}
