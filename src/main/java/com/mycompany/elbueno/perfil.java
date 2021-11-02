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
import dao.UserDAO;
import dto.UserDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author viris
 */
@Named("perfil")
@SessionScoped
public class perfil implements Serializable {

    private String telefono;
    private UserDTO user = StaticAtributes.USER;

    public String direccion() {
        return "direccion.xhtml";
    }

    public String telefono() {
        return "telefono.xhtml";
    }

    public String regresar() {
        return "menu.xhtml";
    }

    public UserDTO getUser() {
        return user;
    }

    public String guardarTelefono() {
        if (Utils.validaCorreo(telefono, StaticAtributes.TELEFONO)) {
            if (new UserDAO().updatePhone(telefono)) {
                Utils.makeMessege("Numero de telefono actualizado");
                return "telefono.xhtml";
            } else {
                Utils.makeMessege("Ocurrio un error intentelo mas tarde");
            }
        } else {
            Utils.makeMessege("El numero de telefono esta mal");
        }
        return "telefono.xhtml";
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
