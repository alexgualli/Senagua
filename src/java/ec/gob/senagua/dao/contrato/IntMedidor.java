/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.Medidor;
import java.util.List;

/**
 *
 * @author paul
 */
public interface IntMedidor {
    
    public int insertar(Medidor medidor) throws Exception;

    public Medidor obtenerCodigo(String id) throws Exception;
    
    public List<Medidor> obtenerTodos() throws Exception;

    public int actualizar(Medidor medidor) throws Exception;

    public int eliminar(String id) throws Exception;
    
}
