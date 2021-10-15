package com.mycompany.elbueno;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("access")
@SessionScoped
public class Access implements Serializable {

    private String email;
    private String password;

    public String validar() {

        if (password == null || email == null
                || password == "" || email == "" || password.length() == 0
                || email.length() == 0) {
            makeMessege("ESCRIBA UN CORREO Y UNA CONTRASENIA");
        } else {
            if (password.length() < 5 || password.length() > 20) {
                makeMessege("LA CONTRASENIA DEBE TENER DE 5 A 20 CARACTERES");
            } else {
                if (validaCorreo(email)) {
                    if (new Validacion().validarLoogin(email, password)) {
                        return "menu.xhtml";
                    } else {
                        makeMessege("EL USUARIO Y CONTRASENIA NO COINCIDEN");
                    }
                }else{
                    makeMessege("CORREO NO VALIDO");
                }
            }
        }
        return "inicio.xhtml";
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

    private boolean validaCorreo(String email) {
        System.out.println("Validando correo" + email.length());

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // El email a validar
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Imprime mensaje en la parte inferior izq de la pantalla
     * @param message
     */
    public void makeMessege(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
}
