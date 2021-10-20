/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elbueno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author irvcal
 */
public class Utils {

    public static boolean validaCamposVacios(String... campos){
        for(String e : campos){
            if(e.equals(""))return false;
        }
        return true;
    }
    /**
     * Valida un ya sea el correo o los nombres
     *
     * @param email
     * @param c = 1-> correo 2-> nombre
     * @return
     */
    public static boolean validaCorreo(String email, int c) {
        System.out.println("Validando correo" + email.length());
        String regex = "";
        if (c == 1) {
            regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        } else {
            //hace falta arreglar el regex para que valide los caracteres especiales
            System.out.println("No es correo es nombre");
//            regex = "^(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            return true;
        }
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
     *
     * @param message
     */
    public static void makeMessege(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
   
    public static void closeConections(Connection conexion,ResultSet resultSet, PreparedStatement preparedStatement){
        try {
            conexion.close();
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error closeConections");
        }
    }
        

}
