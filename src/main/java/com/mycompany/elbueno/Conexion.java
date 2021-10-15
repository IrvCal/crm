/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author viris
 */
public class Conexion {
    private String user="postgres";
    private String pass="123456";
    private Connection cn=null;
    public Conexion() {

    }

    public Connection conectarse() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("conectarse");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crm", user, pass);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            
        }
        return cn;
    }

}
