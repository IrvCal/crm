/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.elbueno.Conexion;
import com.mycompany.elbueno.StaticAtributes;
import com.mycompany.elbueno.Utils;
import dto.DireccionDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author irvcal
 */
public class DireccionDAO {

    private Conexion con;
    private Connection cn;
    private PreparedStatement ps;
    private String query;
    
    public boolean saveAddresToDB(DireccionDTO direccion) {
        try {
            con = new Conexion();
            cn = con.conectarse();
            query = "insert into addresses (id_user,calle,colonia,municipio,estado,cp)"
                    + " values("+StaticAtributes.USER.getId()+",'"+direccion.getCalle()+"','"+direccion.getColonia()+"','"
                    +direccion.getMunicipio()+"','"+direccion.getEstado()+"','"+direccion.getCp()+"')";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            Utils.closeConections(cn, ps);
            return true;
        } catch (Exception e) {
            System.out.println("Error updatePhone" + e.toString());
        }
        return false;
    }

}
