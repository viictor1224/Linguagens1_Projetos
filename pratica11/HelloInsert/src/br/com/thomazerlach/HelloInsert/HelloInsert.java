/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.HelloInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomazerlach
 */
public class HelloInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexao = ConnectionFactory.getConnection();
        
        //String sql = "INSERT INTO tblalunos (`nome`,`idade`,`ra`) VALUE ('Mario', 15, '0000031')";
        String sql = "INSERT INTO tblalunos (`nome`,`idade`,`ra`) VALUE (?, ?, ?)";
        
        PreparedStatement ps;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "OutroTiago");
            ps.setInt(2, 15);
            ps.setString(3, "2222222");
            ps.execute();
           
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(HelloInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
