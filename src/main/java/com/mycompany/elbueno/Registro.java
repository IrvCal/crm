/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import dao.UserDAO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author viris
 */
@Named("registro")
@SessionScoped
public class Registro implements Serializable {

    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String pass;
    private String passRep;
    private String email;

    public String getPassRep() {
        return passRep;
    }

    public void setPassRep(String passRep) {
        this.passRep = passRep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }
    private String validated;

    public String menu() {
        return "menu.xhtml";
    }

    public String registrarUsuario() {

        //La abundancia de los ifs es el poder de las redes neuronales hoy en dia XD
        if (Utils.camposNoVacios(nombre, apMaterno, apPaterno, email, pass, passRep)) {
            if (Utils.validaCorreo(nombre, 2)) {
                if (Utils.validaCorreo(apPaterno, 2)) {
                    if (Utils.validaCorreo(nombre, 2)) {
                        if (Utils.validaCorreo(email, 1)) {
                            if (pass.length() < 5 || pass.length() > 20) {
                                Utils.makeMessege("La contrasenia debe de tener de 5 a 20 caracteres, longitud actual: "+pass.length());
                            } else {
                                if (passRep.equals(pass)) {
                                    int response = new UserDAO().insertUser(nombre, apPaterno, apMaterno, email, pass);
                                    switch (response) {
                                        case 0:
                                            Utils.makeMessege("Hubo un error guardando tu contraseña, intentalo mas tarde");
                                            break;
                                        case 1:
                                            Utils.makeMessege("El usuario se registro correctamente");
                                            break;
                                        case 2:
                                            Utils.makeMessege("Correo ya registrado porfavor intente con otro");
                                            break;
                                        case 3:
                                             Utils.makeMessege("Ocurrio un error guardando al usuario");
                                            break;
                                        default:
                                            Utils.makeMessege("Occurrio un error, intentelo mas tarde");
                                            break;
                                    }

                                } else {
                                    Utils.makeMessege("Las contrasenias no coinciden");
                                }
                            }
                        } else {
                            Utils.makeMessege("El formato del correo no coincide");
                        }
                    } else {
                        Utils.makeMessege("El apellido materno contiene caracteres especiales");
                    }
                } else {
                    Utils.makeMessege("El apellido paterno contiene caracteres especiales");
                }
            } else {
                Utils.makeMessege("El nombre contiene caracteres especiales");
            }
        } else {
            Utils.makeMessege("Favor de llenar correcatmente el formulario");
        }
//        System.out.println("Registrando");
//        System.out.println(toString());
        return "registro.xhtml";
    }

    @Override
    public String toString() {
        return "Registro{" + "nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", pass=" + pass + ", passRep=" + passRep + ", email=" + email + ", validated=" + validated + '}';
    }

}
