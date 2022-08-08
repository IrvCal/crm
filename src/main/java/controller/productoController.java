/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import models.Producto;
import service.ProdcutoService;

/**
 *
 * @author viris
 */
public class productoController {

    /**
     * @return the producto
     */
    //aqui va un comentario de prueba
    public List<Producto> getCarrito(String id) {
       return productos = service.getProducts(id);
    }  
    private List<Producto> productos;
    private ProdcutoService service = new ProdcutoService();
    
}
