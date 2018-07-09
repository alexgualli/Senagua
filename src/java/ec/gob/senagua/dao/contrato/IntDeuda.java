/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.Deuda;
import java.util.List;

/**
 *
 * @author paul
 */
public interface IntDeuda {
    
    public int insertar(Deuda deuda) throws Exception;

    public Deuda obtenerCodigo(int id) throws Exception;
    
    public List<Deuda> obtenerTodos() throws Exception;

    public int actualizar(Deuda deuda) throws Exception;

    public int eliminar(int id) throws Exception;
    
}
