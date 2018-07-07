/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntServicio;
import ec.gob.senagua.entidades.Servicio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class ImpServicio implements IntServicio {
    
    Coneccion con = new Coneccion();
    
    @Override
    public int insertar(Servicio servicio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Servicio obtenerCodigo(int id) throws Exception {
        Servicio servicio = null;
        String sql = "SELECT SELECT codigo, tipo_de_servicio, costo_minimo, minimo_m3, costo_excedente\n"
                + "  FROM public.servicio "
                + "WHERE codigo = ? ";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
                servicio = new Servicio();
                servicio.setCodigo(rst.getInt("codigo"));
                servicio.setTipoSer(rst.getString("tipo_de_servicio"));
                servicio.setCostoMin(rst.getDouble("costo_minimo"));
                servicio.setMinimoM3(rst.getDouble("minimo_m3"));
                servicio.setCostoExc(rst.getDouble("costo_excedente"));
            }
        } catch (Exception e) {
            throw e;
        }
        return servicio;
    }
    
    @Override
    public List<Servicio> obtenerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int actualizar(Servicio servicio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
