/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.elbueno.Conexion;
import com.mycompany.elbueno.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Producto;
import service.ProdcutoService;

/**
 *
 * @author viris
 */
public class productosDao {
    
    
    private Conexion con = new Conexion();
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
   

    public List<Producto> getShop(String id) {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;
        try {
            String script = "select * from carrito where id_user = ".concat(id);
            con = new Conexion();
            cn = con.conectarse();
            ps = cn.prepareStatement(script);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int status = rs.getInt("status");
                    if(status==1){
                    producto = new Producto();
                        System.out.println(rs.getString("nombre"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getLong("precio"));
                    producto.setInventario(rs.getInt("id"));
                    productos.add(producto);
                    }       
                }
            } else {
                System.out.println("No hay datos");
            }
            Utils.closeConections(cn, rs, ps);
        } catch (Exception e) {
            System.out.println("Error DireccionSecurity: " + e.toString());
        }
        return productos;
    }
    public static void main(String[] args) {
        productosDao productosDao1 = new productosDao();
        productosDao1.getShop("1");
    }
}
