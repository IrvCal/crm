/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elbueno;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author viris
 */
public class Validacion {

    private Conexion con;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean validarLoogin(String email, String pass) {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            System.out.println("Username: " + email + " Password: " + pass);
            request.login(email, pass);
        } catch (Exception ex) {
            System.out.println("\n\n\n\n\n\nException 1 from Servlet: " + ex.toString());

            if (ex.getMessage().contains("Login failed")) {
                //setErrorMessage("login.faild");
                //System.out.println("\n\n\n\n\n\nException 2 from Servlet: " + ex.toString());

                return false;
            }
            return true;
        }

        return false;
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            externalContext.invalidateSession();
            request.logout();
        } catch (ServletException ex) {
            System.out.println("Excepcion en logout");
            return "error";
        }

        //setErrorMessage("");
        //setErrorsCounter(0);
        return "/index.xhtml?faces-redirect=true";
    }
}
