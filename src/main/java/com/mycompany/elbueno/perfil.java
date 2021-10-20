/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

/**
 *
 * @author viris
 */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author viris
 */
@Named("perfil")
@SessionScoped
public class perfil implements Serializable{
    
    public String direccion ()
    {
        return "direccion.xhtml";
    }
    
    public String telefono ()
    {
        return "telefono.xhtml";
    }
    
    
    
    public String regresar ()
    {
        return "menu.xhtml";
    }
    
}

