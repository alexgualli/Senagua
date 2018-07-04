/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paul
 */
public class Cliente {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
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

    
    public Cliente(int codigo, String nombre, String apellido, String direccion, String cedula, String correo, String fechaNac, int codigoDis) {
        this.codigo = codigo;        
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
        try {
            this.fechaNac =sdf.parse(fechaNac);
        } catch (ParseException e) {
            System.err.println("No se ha podido definir las fechas. " + e.getMessage());
        }        
        this.codigoDis = codigoDis;
    }
    
     public void setFechaNac(String fechaNac) {
        try {
            this.fechaNac = sdf.parse(fechaNac);
        } catch (ParseException e) {
            System.err.println("No se ha podido definir la fecha de inicio. " + e.getMessage());
        }

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

   
    @Override
    public String toString(){
        return this.nombre+" "+this.apellido;
    }
    

    
    
    
    
    
    
}
