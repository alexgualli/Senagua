/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.Servicio;
import java.util.List;

/**
 *
 * @author paul
 */
public interface IntServicio {
    
    public int insertar(Servicio servicio) throws Exception;

    public Servicio obtenerCodigo(int id) throws Exception;
    
    public List<Servicio> obtenerTodos() throws Exception;

    public int actualizar(Servicio servicio) throws Exception;

    public int eliminar(int id) throws Exception;
    
}
