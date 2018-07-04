/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.entidades;

/**
 *
 * @author NuevoUsuario
 */
public class Usuario {

    private int codigo;
    private String nombre;
    private String clave;
    private String tipo;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String clave, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

 
    @Override
    public String toString(){
         return nombre+" "+tipo;
    }    
   

}
