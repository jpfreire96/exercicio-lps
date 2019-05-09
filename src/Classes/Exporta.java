/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jpfreire
 */
public class Exporta {

    public String exportAluno(ArrayList<Aluno> alunos) {
        File file = new File("base/Alunos.csv");
        int lenght = alunos.size();
        System.out.println(lenght);
        String response = "";
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            for (int i = 0; i < lenght; i++) {
                Aluno temp = alunos.get(i);
                bf.write(temp.getCod() + ";" + temp.getNome() + ";" + temp.getCpf() + "\n");
            }
            bf.flush();
            bf.close();
            response = "success";

        } catch (IOException e) {
            response = e.toString();
        }
        return response;
    }

    public String exportCurso(ArrayList<Curso> cursos) {
        File file = new File("base/Cursos.csv");
        int lenght = cursos.size();
        String response = "";
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            for (int i = 0; i < lenght; i++) {
                Curso temp = cursos.get(i);
                bf.write(temp.getCod() + ";" + temp.getNome() + ";" + temp.getCargaH() + "\n");
            }
            bf.flush();
            bf.close();
            response = "success";

        } catch (IOException e) {
            response = e.toString();
        }
        return response;
    }

    public String exportMatricula(ArrayList<Matricula> matriculas) {
        File file = new File("base/Matriculas.csv");
        int lenght = matriculas.size();
        String response = "";
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bf = new BufferedWriter(fw);
            for (int i = 0; i < lenght; i++) {
                Matricula temp = matriculas.get(i);
                bf.write(temp.getNumMatricula() + ";" + temp.getDataMatricula() + ";" + temp.getAluno().getNome() + ";" + temp.getCurso().getNome() + "\n");
            }
            bf.flush();
            bf.close();
            response = "success";

        } catch (IOException e) {
            response = e.toString();
        }
        return response;
    }
    
        public String exportMatriculaSubstitui(ArrayList<Matricula> matriculas) {
        File file = new File("base/Matriculas.csv");
        int lenght = matriculas.size();
        String response = "";
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            for (int i = 0; i < lenght; i++) {
                Matricula temp = matriculas.get(i);
                bf.write(temp.getNumMatricula() + ";" + temp.getDataMatricula() + ";" + temp.getAluno().getNome() + ";" + temp.getCurso().getNome() + "\n");
            }
            bf.flush();
            bf.close();
            response = "success";

        } catch (IOException e) {
            response = e.toString();
        }
        return response;
    }
}
