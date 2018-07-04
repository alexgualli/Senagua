/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntConsumo;
import ec.gob.senagua.entidades.Consumo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ImpConsumo implements IntConsumo{
    
    Coneccion con = new Coneccion();

    @Override
    public int insertar(Consumo consumo) throws Exception {
        int insert =0;
        String sql = "INSERT INTO public.consumo(fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor)\n" +
                     "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, consumo.getFecha()));
        prts.add(new Parametro(2, consumo.getLecturaAnt()));
        prts.add(new Parametro(3, consumo.getLecturaAct()));
        prts.add(new Parametro(4, consumo.getConsumo()));
        prts.add(new Parametro(5, consumo.getMedidor().getCodigo()));
        
        if(consumo.getCodigo()!= 0){
            sql ="INSERT INTO consumo(fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor, codigo)\n" +
            "    VALUES (?, ?, ?, ?, ?, ?);";
            prts.add(new Parametro(6, consumo.getCodigo()));
        }
        try {
            insert=con.querySet(sql, prts);            
        } catch (Exception e) {
            throw e;
        }
        return insert;
    }

    @Override
    public Consumo obtenerCodigo(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consumo> obtenerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Consumo usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete=0;
        String sql = "DELETE FROM public.consumo\n" +
                     " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            delete=con.querySet(sql,prts);
        } catch (Exception e) {
            throw e;
        }
        return delete;
    }
    
}
