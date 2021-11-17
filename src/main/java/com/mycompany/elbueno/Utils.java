/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elbueno;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    private static final String DIGEST_ALGORITHM = "SHA-256";
    private static final String CHARSET = "UTF-8";

    public static boolean camposNoVacios(String... campos) {
        for (String e : campos) {
            if (e.equals("")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida un ya sea el correo o los nombres
     *
     * @param email
     * @param c = 1-> correo 2-> nombre 3-> telefono
     * @return
     */
    public static boolean validaCorreo(String email, int c) {
        String regex = "";
        if (c == 1) {
            regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        } else if (c == 2) {
            //hace falta arreglar el regex para que valide los caracteres especiales
            System.out.println("No es correo es nombre");
//            regex = "^(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            return true;
        } else if (c == 3) {
            //valida que sea un numero
            boolean isNumeric = email.matches("[+-]?\\d*(\\.\\d+)?");
            return isNumeric;
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

    public static void closeConections(Connection conexion, ResultSet resultSet, PreparedStatement preparedStatement) {
        try {
            conexion.close();
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error closeConections");
        }
    }

    public static void closeConections(Connection conexion, PreparedStatement preparedStatement) {
        try {
            conexion.close();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error closeConections");
        }
    }

    public static boolean correoExisteDB(String email) {

        Conexion con;
        Connection cn;
        PreparedStatement ps;
        ResultSet rs;
        String query;
        try {
            return true;
            /*query = "select * from users where user_name = '" + email + "'";
            con = new Conexion();
            cn = con.conectarse();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Usuario existente");
                closeConections(cn, rs, ps);
                return true;
            }
            closeConections(cn, rs, ps);*/
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Metodo para pasar la contraseña a SHA-256
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String DigestSHA256(String data) throws UnsupportedEncodingException {
        StringBuilder toHexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM);
            byte[] hash = md.digest(data.getBytes(CHARSET));
            for (int i = 0; i < hash.length; i++) {
                String tempHex = Integer.toHexString(0xff & hash[i]);
                if (tempHex.length() == 1) {
                    toHexString.append('0');
                }
                toHexString.append(tempHex);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Error "+ex.toString());
        }
        System.out.println("HEX" +  toHexString.toString());
        return toHexString.toString();
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(DigestSHA256("123456"));
    }
}
