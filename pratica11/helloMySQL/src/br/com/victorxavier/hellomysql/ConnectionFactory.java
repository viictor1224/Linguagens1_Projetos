/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.victorxavier.hellomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jbdc:mysql://localhost/alunostestes","root", "XXXXXX");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
