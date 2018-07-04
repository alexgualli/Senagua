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
public class Consumo {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private int codigo;
    private Date fecha;
    private int lecturaAnt;
    private int lecturaAct;
    private double consumo;
    private Medidor medidor;

    public Consumo() {
    }
    
    

    public Consumo(int codigo, Date fecha, int lecturaAnt, int lecturaAct, double consumo, Medidor medidor) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.lecturaAnt = lecturaAnt;
        this.lecturaAct = lecturaAct;
        this.consumo = consumo;
        this.medidor = medidor;
    }
    
    public Consumo(int codigo, String fecha, int lecturaAnt, int lecturaAct, double consumo, Medidor medidor) {
        this.codigo = codigo;
        try {
            this.fecha =sdf.parse(fecha);
        } catch (ParseException e) {
            System.err.println("No se ha podido definir las fechas. " + e.getMessage());
        }      
        this.lecturaAnt = lecturaAnt;
        this.lecturaAct = lecturaAct;
        this.consumo = consumo;
        this.medidor = medidor;
    }
    
    public void setFecha(String fecha) {
        try {
            this.fecha = sdf.parse(fecha);
        } catch (ParseException e) {
            System.err.println("No se ha podido definir la fecha de inicio. " + e.getMessage());
        }

    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLecturaAnt() {
        return lecturaAnt;
    }

    public void setLecturaAnt(int lecturaAnt) {
        this.lecturaAnt = lecturaAnt;
    }

    public int getLecturaAct() {
        return lecturaAct;
    }

    public void setLecturaAct(int lecturaAct) {
        this.lecturaAct = lecturaAct;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    
    @Override
    public String toString(){
        return this.fecha+" "+ this.lecturaAnt+" "+ this.lecturaAct;
    }
    
    
    
    
    
}
