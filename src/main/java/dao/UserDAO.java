/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.elbueno.Conexion;
import com.mycompany.elbueno.StaticAtributes;
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
    private String query;

    public int insertUser(String nombre, String apPat, String apMat, String email, String pass) {
        try {
            if (Utils.correoExisteDB(email)) {
                System.out.println("Usuario existente");
                return 2;
            } else {
                con = new Conexion();
                cn = con.conectarse();
                query = "insert into users (name,apPat,apMat,user_name,password) values ('"
                        + nombre + "','" + apPat + "','" + apMat + "','" + email + "','" + pass + "')";
                ps = cn.prepareStatement(query);
                ps.executeUpdate();

                Utils.closeConections(cn, ps);
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error de guardado de usuario " + e);
        }
        return 3;
    }

    public boolean updatePhone(String telefono) {
        try {
            con = new Conexion();
            cn = con.conectarse();
            query = "update users set telefono = '"+telefono+"' where id = "+StaticAtributes.USER.getId();
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            StaticAtributes.USER.setTelefono(telefono);
            Utils.closeConections(cn, ps);
            return true;
        } catch (Exception e) {
            System.out.println("Error updatePhone" + e.toString());
        }
        return false;
    }
}
