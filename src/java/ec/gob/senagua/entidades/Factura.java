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
public class Factura {
    
    private int codigo;
    private Cliente cliente;
    private Usuario usuario;
    private String observacion;
    private String estado;
    private Date fechaEmi;
    private double total;
    private DetalleFactura detalle;
    private double descuento;

    public Factura() {
    }

    public Factura(int codigo, Cliente cliente, Usuario usuario, String observacion, String estado, Date fechaEmi, double total, DetalleFactura detalle, double descuento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.usuario = usuario;
        this.observacion = observacion;
        this.estado = estado;
        this.fechaEmi = fechaEmi;
        this.total = total;
        this.detalle = detalle;
        this.descuento = descuento;
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

    public DetalleFactura getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleFactura detalle) {
        this.detalle = detalle;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    

 
    
}
