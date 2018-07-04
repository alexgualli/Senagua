/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.entidades;

import java.sql.Date;

/**
 *
 * @author paul
 */
public class Cliente {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String correo;
    private Date fechaNac;
    private int codigoDis;

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido, String direccion, String cedula, String correo, Date fechaNac, int codigoDis) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.codigoDis = codigoDis;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getCodigoDis() {
        return codigoDis;
    }

    public void setCodigoDis(int codigoDis) {
        this.codigoDis = codigoDis;
    }
    
    

    
    
    
    
    
    
}
