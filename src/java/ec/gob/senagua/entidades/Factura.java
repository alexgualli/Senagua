/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.entidades;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author paul
 */
public class Factura {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    private int codigo;
    private Cliente cliente;
    private Usuario usuario;
    private String observacion;
    private Medidor medidor;
    private String estado;
    private Date fechaEmi;
    private double total;
    private double descuento;

    public Factura() {
    }

    public Factura(int codigo, Cliente cliente, Usuario usuario, String observacion, Medidor medidor, String estado, Date fechaEmi, double total, double descuento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.usuario = usuario;
        this.observacion = observacion;
        this.medidor = medidor;
        this.estado = estado;
        this.fechaEmi = fechaEmi;
        this.total = total;
        this.descuento = descuento;
    }

    

    public Factura(int codigo, Cliente cliente, Usuario usuario, String observacion, Medidor medidor, String estado, String fechaEmi, double total, double descuento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.usuario = usuario;
        this.observacion = observacion;
        this.medidor = medidor;
        this.estado = estado;
        
        try {
            this.fechaEmi =sdf.parse(fechaEmi);
        } catch (ParseException e) {
            System.err.println("No se ha podido definir las fechas. " + e.getMessage());
        }    
        this.total = total;
        this.descuento = descuento;
    }
    
    public void setFechaEmi(String fechaEmi) {
        try {
            this.fechaEmi = sdf.parse(fechaEmi);
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEmi() {
        return fechaEmi;
    }

    public void setFechaEmi(Date fechaEmi) {
        this.fechaEmi = fechaEmi;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }    

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
    @Override
    public String toString(){
        return this.observacion+" "+this.fechaEmi+" "+this.total;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }
        
 
    
}
