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
    private String password;
    private String cargo;

    public Usuario() {
    }
    
   

    public Usuario(int codigo, String nombre, String password, String cargo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.cargo = cargo;
    }

  
   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
         return nombre;
    }
}
