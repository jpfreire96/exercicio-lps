/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author jpfreire
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Connection conn = null;

    private Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/schooldatabase", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível encontrar o Driver especificado " + e);
        } catch (SQLException ex) {
            System.out.println("Não foi possível conectar ao BD " + ex);
        }
    }

    public static Connection conexao() {
        if (conn == null) {
            new Conexao();
        }
        return conn;
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}