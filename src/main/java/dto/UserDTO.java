/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author irvcal
 */
public class UserDTO {

    private int id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String pass;
    private String passRep;
    private String email;
    private String telefono;

    public UserDTO() {
    }

    public UserDTO(String nombre, String apPaterno, String apMaterno, String pass, String passRep, String email) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.pass = pass;
        this.passRep = passRep;
        this.email = email;
    }

    public UserDTO(int id, String nombre, String apPaterno, String apMaterno, String pass, String email,String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.pass = pass;
        this.passRep = passRep;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassRep() {
        return passRep;
    }

    public void setPassRep(String passRep) {
        this.passRep = passRep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", pass=" + pass + ", passRep=" + passRep + ", email=" + email + '}';
    }

}
