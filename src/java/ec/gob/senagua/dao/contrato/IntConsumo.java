/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.Consumo;
import java.util.List;

/**
 *
 * @author paul
 */
public interface IntConsumo {
    
    public int insertar(Consumo consumo) throws Exception;

    public Consumo obtenerCodigo(int id) throws Exception;
    
    public List<Consumo> obtenerTodos() throws Exception;

    public int actualizar(Consumo consumo) throws Exception;

    public int eliminar(int id) throws Exception;
    
}
