/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author jpfreire
 */
public class Matricula {
    private int     numMatricula;
    private String  dataMatricula;
    private Aluno   aluno;
    private Curso   curso;
    
    public Matricula(){
        this.numMatricula = -1;
        this.dataMatricula = "";
        this.aluno = null;
        this.curso = null;
    }
      public Matricula(int numMatricual, String dataMatricula, Aluno aluno, Curso curso){
        this.numMatricula = numMatricual;
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
        this.curso = curso;
    }

    /**
     * @return the numMatricula
     */
    public int getNumMatricula() {
        return numMatricula;
    }

    /**
     * @param numMatricula the numMatricula to set
     */
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    /**
     * @return the dataMatricula
     */
    public String getDataMatricula() {
        return dataMatricula;
    }

    /**
     * @param dataMatricula the dataMatricula to set
     */
    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
