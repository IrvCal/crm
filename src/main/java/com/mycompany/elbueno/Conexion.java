/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author viris
 */
public class Conexion {

    private String user = "postgres";
    private String pass = "123456";
    private Connection cn = null;

    InitialContext ic;
    private DataSource ds = null;

    public Conexion() {
        try {
            System.out.println("mypool_resourse");
            this.ic = new InitialContext();
            ds = (DataSource) ic.lookup("jdbc/mypool_resourse");
        } catch (NamingException ex) {
            System.out.println("Naming exception en clase Conexion");
        }
    }

    public Connection conectarse() {
        /*try {
            Class.forName("org.postgresql.Driver");
            System.out.println("conectarse");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crm", user, pass);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {

        }*/
        Connection con = null;
        try {
            con = ds.getConnection();

            if (con != null) {
                System.out.println("SUCCESFUL connection to the database --ORACLE--");
            } else {
                System.out.println("FAILED connection attempt to the database --ORACLE--");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    public ResultSet selectReturn(String script) {
        ResultSet resultSet = null;
        Statement p = null;
        conectarse();
        try {
            p = cn.createStatement();
            resultSet = p.executeQuery(script);
            if (resultSet.next()) {
                System.out.println("Tiene");
                return resultSet;
            } else {
                System.out.println("No tiene");
                return null;
            }
            //return resultSet;

        } catch (Exception e) {
            System.out.println("Exepcion Conection: " + e.toString());
            return resultSet;
        }
    }

}
