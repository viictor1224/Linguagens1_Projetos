/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.victorxavier.hellomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victorxavier
 */
public class HelloMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tblalunos;";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                int id = resultadoQuery.getInt("id");
                String nome = resultadoQuery.getString("nome");
                int idade = resultadoQuerygetInt("idade");
                String ra = resultadoQuery.getString("ra");

                System.out.println(Integer.toString(id) + " nome: " + nome);
            }
            ps.close();
            conexao.close();
        }catch(SQLException ex){
            
        }
    }

    private static int resultadoQuerygetInt(String idade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
