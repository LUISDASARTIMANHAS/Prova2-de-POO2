/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 1547816
 */
public class ConexaoPSQL {
    private static Connection conexao;
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        
        // POSTGRESQL
        String url = "jdbc:postgresql://localhost:5432/prova2_vendas";
        String user = "postgres";
        String password = "postgres";
        
        Class.forName("org.postgresql.Driver");
        
                
        conexao = DriverManager.getConnection(url, user, password);
        return conexao;
        
        
    }
            
}
