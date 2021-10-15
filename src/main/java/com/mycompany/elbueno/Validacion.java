/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author viris
 */
public class Validacion {

    private Conexion con;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean validarLoogin(String email, String pass) {
        String query = "select * from users where user_name='" + email + "'and password ='" + pass + "';";
        System.out.println(email+pass);
        try {
            con = new Conexion();
            cn = con.conectarse();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()|| rs!= null) {
                System.out.println(rs.getString("user_name")+ "***" + rs.getString("password"));
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

}
