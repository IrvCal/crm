package com.mycompany.elbueno;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("access")
@SessionScoped
public class Access implements Serializable {

    private String email;
    private String password;

    public String validar() {
        System.out.println("Validando");
        if (password == null || email == null
                || password == "" || email == "" || password.length() == 0
                || email.length() == 0) {
            Utils.makeMessege("ESCRIBA UN CORREO Y UNA CONTRASEÑA");
        } else {
            if (password.length() < 5 || password.length() > 20) {
               Utils.makeMessege("LA CONTRASENIA DEBE TENER DE 5 A 20 CARACTERES");
            } else {
                if (Utils.validaCorreo(email,1)) {
                    if(Utils.correoExisteDB(email)){
                        if (new Validacion().validarLoogin(email, password)) {
                            return "menu.xhtml";
                        } else {
                            Utils.makeMessege("EL USUARIO Y CONTRASEÑA NO COINCIDEN");
                        }
                    }else{
                        Utils.makeMessege("ESTE CORREO NO ESTA REGISTRADO");
                    }
                    
                }else{
                    Utils.makeMessege("CORREO NO VALIDO");
                }
            }
        }
        return "login.xhtml";
    }

    public String getUser() {
        return email;
    }

    public void setUser(String user) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String registro() {
        return "registro.xhtml";
    }
}
