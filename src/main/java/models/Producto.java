/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author viris
 */
public class Producto {

    public Producto() {
 
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the id_proveedor
     */
    public Integer getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    /**
     * @return the id_categoria
     */
    public Integer getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the inventario
     */
    public Integer getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    /**
     * @return the precio
     */
    public Long getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Producto(Integer id, Integer id_proveedor, Integer id_categoria, String nombre, Integer inventario, Long precio, String descripcion, Integer status) {
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.inventario = inventario;
        this.precio = precio;
        this.descripcion = descripcion;
        this.status = status;
    }
    
    private Integer id;
    private Integer id_proveedor;
    private Integer id_categoria;
    private String nombre;
    private Integer inventario;
    private Long precio;
    private String descripcion;
    private Integer status;    
}
