/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.elbueno.Conexion;
import com.mycompany.elbueno.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author irvcal
 */
public class UserDAO {

    private Conexion con;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insertUser(String nombre, String apPat, String apMat, String email, String pass) {
        String query = "insert into users (name,apPat,apMat,user_name,password) values ('"
                +nombre+"','"+apPat+"','"+apMat+"','"+email+"','"+pass+"')";
        try {
            con = new Conexion();
            cn = con.conectarse();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();
            Utils.closeConections(cn, rs, ps);
        } catch (Exception e) {
            System.out.println("Error de guardado de usuario " + e.toString());
        }
        return true;
    }
}
