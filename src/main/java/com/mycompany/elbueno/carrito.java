/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author viris
 */
@Named("carrito")
@SessionScoped
public class carrito implements Serializable{
    
    public String confirmar ()
    {
        return "confirmarInfo.xhtml";
    }
    
     public String inicio ()
    {
        return "menu.xhtml";
    }
   
}