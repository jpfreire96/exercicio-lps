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

    public int adicionaAluno(Aluno aluno) {
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

    public int atualizaAluno(String[] aluno) {
        try {
            String sql = "UPDATE aluno SET codigo=?, nome=?, cpf=? WHERE nome=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(aluno[1]));
            stmt.setString(2, aluno[2]);
            stmt.setString(3, aluno[3]);
            stmt.setString(4, aluno[0]);
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
