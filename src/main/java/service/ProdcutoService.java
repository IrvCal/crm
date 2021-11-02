/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.productosDao;
import java.util.List;
import models.Producto;

/**
 *
 * @author viris
 */
public class ProdcutoService {
    
    private productosDao proDao = new productosDao();
    
    public List<Producto> getProducts (String id){
        return proDao.getShop(id);
    }
    
}
