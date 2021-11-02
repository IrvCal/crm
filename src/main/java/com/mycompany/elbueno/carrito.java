/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import controller.productoController;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.Producto;

/**
 *
 * @author viris
 */
@Named("carrito")
@SessionScoped
public class carrito implements Serializable{

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the proController
     */
    public productoController getProController() {
        return proController;
    }

    /**
     * @param proController the proController to set
     */
    public void setProController(productoController proController) {
        this.proController = proController;
    }
     
    public String confirmar ()
    {
        return "confirmarInfo.xhtml";
    }
    

    public carrito() {
        productos = proController.getCarrito("1");
        System.err.println("");
    }
    
    private List<Producto> productos;
    private productoController proController = new productoController();
    
}
