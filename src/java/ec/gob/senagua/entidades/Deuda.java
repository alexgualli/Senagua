/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.entidades;

/**
 *
 * @author paul
 */
public class Deuda {
    
    private double valor;
    private Cliente cliente;
    private Factura factura;
    private int mesesPen;
    private int codigo;

    public Deuda() {
    }

    public Deuda(double valor, Cliente cliente, Factura factura, int mesesPen, int codigo) {
        this.valor = valor;
        this.cliente = cliente;
        this.factura = factura;
        this.mesesPen = mesesPen;
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public int getMesesPen() {
        return mesesPen;
    }

    public void setMesesPen(int mesesPen) {
        this.mesesPen = mesesPen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    
}
