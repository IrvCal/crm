/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author irvcal
 */
public class DireccionDTO {

    private String calle;
    private String colonia;
    private String estado;
    private String municipio;
    private String cp;

    public DireccionDTO() {
    }

    public DireccionDTO(String calle, String colonia, String estado, String municipio, String cp) {
        this.calle = calle;
        this.colonia = colonia;
        this.estado = estado;
        this.municipio = municipio;
        this.cp = cp;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "AddressDTO{" + "calle=" + calle + ", colonia=" + colonia + ", estado=" + estado + ", municipio=" + municipio + ", cp=" + cp + '}';
    }

}
