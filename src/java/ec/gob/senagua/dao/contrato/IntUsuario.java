/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.Usuario;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author paul
 */
public interface IntUsuario {
    
    public int insertar(Usuario usuario) throws Exception;

    public Usuario obtenerCodigo(int id) throws Exception;

    public Usuario obtenerLogin(String usuario, String clave) throws Exception;

    public List<Usuario> obtenerTodos() throws Exception;

    public int actualizar(Usuario usuario) throws Exception;

    public int eliminar(int id) throws Exception;
    
}
