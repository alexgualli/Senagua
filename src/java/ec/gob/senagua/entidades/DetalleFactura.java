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
public class DetalleFactura {
    
    private int codigo;
    private String descripcion;
    private Factura factura;
    private double subtotal;
    private Consumo consumo;
    private Servicio servicio;
    private int m3Min;
    private double costoMin;
    private double costoExc;
    private double consumoAct;
    private double consumoAnt;
    private double valorConsumo;
    private double m3Exc;
    private double valorM3Exc;

    public DetalleFactura() {
    }

    public DetalleFactura(int codigo, String descripcion, Factura factura, double subtotal, Consumo consumo, Servicio servicio, int m3Min, double costoMin, double costoExc, double consumoAct, double consumoAnt, double valorConsumo, double m3Exc, double valorM3Exc) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.factura = factura;
        this.subtotal = subtotal;
        this.consumo = consumo;
        this.servicio = servicio;
        this.m3Min = m3Min;
        this.costoMin = costoMin;
        this.costoExc = costoExc;
        this.consumoAct = consumoAct;
        this.consumoAnt = consumoAnt;
        this.valorConsumo = valorConsumo;
        this.m3Exc = m3Exc;
        this.valorM3Exc = valorM3Exc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getM3Min() {
        return m3Min;
    }

    public void setM3Min(int m3Min) {
        this.m3Min = m3Min;
    }

    public double getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public double getCostoExc() {
        return costoExc;
    }

    public void setCostoExc(double costoExc) {
        this.costoExc = costoExc;
    }

    public double getConsumoAct() {
        return consumoAct;
    }

    public void setConsumoAct(double consumoAct) {
        this.consumoAct = consumoAct;
    }

    public double getConsumoAnt() {
        return consumoAnt;
    }

    public void setConsumoAnt(double consumoAnt) {
        this.consumoAnt = consumoAnt;
    }

    public double getValorConsumo() {
        return valorConsumo;
    }

    public void setValorConsumo(double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }

    public double getM3Exc() {
        return m3Exc;
    }

    public void setM3Exc(double m3Exc) {
        this.m3Exc = m3Exc;
    }

    public double getValorM3Exc() {
        return valorM3Exc;
    }

    public void setValorM3Exc(double valorM3Exc) {
        this.valorM3Exc = valorM3Exc;
    }

    public String toString(){
        return this.descripcion+" "+this.subtotal;
    }

    
    
    
    
    
    
    
    
}
