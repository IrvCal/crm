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
@Named("direccion")
@SessionScoped
public class direccion implements Serializable{
    
    private String calle;
    private String colonia;
    private String municipio;
    private String estado;
    private String cp;
    private String no_int;
    private String no_ext;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNo_int() {
        return no_int;
    }

    public void setNo_int(String no_int) {
        this.no_int = no_int;
    }

    public String getNo_ext() {
        return no_ext;
    }

    public void setNo_ext(String no_ext) {
        this.no_ext = no_ext;
    }
  

    
    public String guardar ()
    {
        return "perfilusuario.xhtml";
    }
    
   
    
}