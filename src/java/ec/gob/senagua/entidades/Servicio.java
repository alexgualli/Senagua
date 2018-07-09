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
public class Servicio {
    
    private int codigo;
    private String tipoSer;
    private double costoMin;
    private double minimoM3;
    private double costoExc;

    public Servicio() {
    }

    public Servicio(int codigo, String tipoSer, double costoMin, double minimoM3, double costoExc) {
        this.codigo = codigo;
        this.tipoSer = tipoSer;
        this.costoMin = costoMin;
        this.minimoM3 = minimoM3;
        this.costoExc = costoExc;
    }

    public double getCostoExc() {
        return costoExc;
    }

    public void setCostoExc(double costoExc) {
        this.costoExc = costoExc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoSer() {
        return tipoSer;
    }

    public void setTipoSer(String tipoSer) {
        this.tipoSer = tipoSer;
    }

    public double getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public double getMinimoM3() {
        return minimoM3;
    }

    public void setMinimoM3(double minimoM3) {
        this.minimoM3 = minimoM3;
    }
    
    @Override
    public String toString(){
        return this.tipoSer+" "+this.minimoM3+" "+this.costoMin+" "+this.costoExc ;
    }
    
    
}
