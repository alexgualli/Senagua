/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntMedidor;
import ec.gob.senagua.entidades.Cliente;
import ec.gob.senagua.entidades.Medidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ImpMedidor implements IntMedidor{
    
    Coneccion con = new Coneccion();

    @Override
    public int insertar(Medidor medidor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medidor obtenerCodigo(String id) throws Exception {
        Medidor medidor = null;
        String sql = "SELECT codigo, codigo_cliente, tipo_de_medidor\n" +
                     "  FROM medidor "
                + "WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while(rst.next()){
                medidor = new Medidor();
                medidor.setCodigo(rst.getString("codigo"));
                medidor.setTipoMed(rst.getString("tipo_de_medidor"));
                try {
                    ImpCliente cliente = new ImpCliente();
                    medidor.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));                    
                } catch (Exception e) {
                    throw e;
                }              
            }
        } catch (Exception e) {
            throw e;
        }
        return medidor;
    }

    @Override
    public List<Medidor> obtenerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Medidor medidor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
