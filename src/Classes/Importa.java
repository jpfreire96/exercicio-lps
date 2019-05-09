/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jpfreire
 */
public class Importa {

    public ArrayList<Aluno> importAluno() {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        File file = new File("base/Alunos.csv");
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String teste;
                while ((teste = br.readLine()) != null) {
                    String[] textoQuebrado = teste.split(";");
                    Aluno temp = new Aluno(Integer.parseInt(textoQuebrado[0]), textoQuebrado[1], textoQuebrado[2]);
                    alunos.add(temp);
                }
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
                return null;
            }
        }
        return alunos;
    }

    public ArrayList<Curso> importCurso() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        File file = new File("base/Cursos.csv");
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String teste;
                if ((teste = br.readLine()) != null) {
                    String[] textoQuebrado = teste.split(";");
                    Curso temp = new Curso(Integer.parseInt(textoQuebrado[0]), textoQuebrado[1], Integer.parseInt(textoQuebrado[2]));
                    cursos.add(temp);
                }
                br.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
                return null;
            }
        }
        return cursos;
    }

    public ArrayList<Matricula> importMatricula() {
        SchoolProject escola = new SchoolProject();
        ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
        File file = new File("base/Matriculas.csv");
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String teste;
                while ((teste = br.readLine()) != null) {
                    String[] textoQuebrado = teste.split(";");
                    Aluno tempAluno = escola.findAluno(textoQuebrado[2]);
                    Curso tempCurso = escola.findCurso(textoQuebrado[3]);
                    Matricula temp = new Matricula(Integer.parseInt(textoQuebrado[0]), textoQuebrado[1], tempAluno, tempCurso);
                    matriculas.add(temp);
                }
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
                return null;
            }
        }
        return matriculas;
    }
}
