/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Aluno;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpfreire
 */
public class AlunoDAO {

    private Connection conn;

    public int verificaAluno(Aluno aluno) {
        ArrayList<Object> lista = buscarAlunoNaBase(aluno);
        if (lista.size() == 0) {
            return adicionaAluno(aluno);
        } else {
            return atualizaAluno(aluno);
        }
    }

    private ArrayList<Object> buscarAlunoNaBase(Aluno aluno) {
        try {
            String sql = "SELECT * FROM aluno WHERE aluno.nome='" + aluno.getNome() + "'";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Object> dados = new ArrayList<>();
            while (rs.next()) {
                Aluno temp = new Aluno(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"));
                dados.add(temp);
            }
            return dados;

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String[]> buscarAlunoNaBase() {
        try {
            String sql = "SELECT * FROM aluno";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String[]> dados = new ArrayList<>();
            while (rs.next()) {
                String[] data = {String.valueOf(rs.getInt("id")), String.valueOf(rs.getInt("codigo")), rs.getString("nome"), rs.getString("cpf")};
                dados.add(data);
            }
            return dados;

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private int adicionaAluno(Aluno aluno) {
        try {
            String sql = "INSERT INTO aluno (codigo, nome, cpf) VALUES (?,?,?)";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getCod());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    private int atualizaAluno(Aluno aluno) {
        try {
            String sql = "UPDATE aluno SET codigo=?, cpf=? WHERE nome=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getCod());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getNome());
            stmt.execute();
            return 2;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int excluiAluno(int id) {
        try {
            String sql = "DELETE FROM aluno WHERE id=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
