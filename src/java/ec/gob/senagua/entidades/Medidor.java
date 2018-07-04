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
public class Medidor {
    
    private String codigo;
    private Cliente cliente;
    private String tipoMed;

    public Medidor() {
    }

    public Medidor(String codigo, Cliente cliente, String tipoMed) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipoMed = tipoMed;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoMed() {
        return tipoMed;
    }

    public void setTipoMed(String tipoMed) {
        this.tipoMed = tipoMed;
    }

    
    
}
