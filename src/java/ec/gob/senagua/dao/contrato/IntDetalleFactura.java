/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.dao.contrato;

import ec.gob.senagua.entidades.DetalleFactura;
import java.util.List;

/**
 *
 * @author paul
 */
public interface IntDetalleFactura {
    
    public int insertar(DetalleFactura detalle) throws Exception;

    public DetalleFactura obtenerCodigo(int id) throws Exception;
    
    public List<DetalleFactura> obtenerTodos() throws Exception;

    public int actualizar(DetalleFactura detalle) throws Exception;

    public int eliminar(int id) throws Exception;
    
}
