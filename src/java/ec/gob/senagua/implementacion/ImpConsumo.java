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
import ec.gob.senagua.entidades.Medidor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ImpConsumo implements IntConsumo {

    Coneccion con = new Coneccion();

    @Override
    public int insertar(Consumo consumo) throws Exception {
        int insert = 0;
        String sql = "INSERT INTO public.consumo(fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, consumo.getFecha()));
        prts.add(new Parametro(2, consumo.getLecturaAnt()));
        prts.add(new Parametro(3, consumo.getLecturaAct()));
        prts.add(new Parametro(4, consumo.getConsumo()));
        prts.add(new Parametro(5, consumo.getMedidor().getCodigo()));

        if (consumo.getCodigo() != 0) {
            sql = "INSERT INTO consumo(fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor, codigo)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?);";
            prts.add(new Parametro(6, consumo.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return insert;
    }

    @Override
    public Consumo obtenerCodigo(int id) throws Exception {
        Consumo consumo = null;
        String sql = "SELECT codigo, fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor "
                + " FROM public.consumo "
                + "WHERE codigo = ? ";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
                consumo = new Consumo();
                consumo.setCodigo(rst.getInt("codigo"));
                consumo.setFecha(rst.getDate("fecha"));
                consumo.setLecturaAnt(rst.getInt("lectura_anterior"));
                consumo.setLecturaAct(rst.getInt("lectura_actual"));
                consumo.setConsumo(rst.getDouble("consumo"));
                try {
                    ImpMedidor medidor = new ImpMedidor();
                    consumo.setMedidor(medidor.obtenerCodigo(rst.getString("codigo_medidor")));
                } catch (SQLException e) {
                    throw e;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return consumo;
    }

    @Override
    public List<Consumo> obtenerTodos() throws Exception {
        List<Consumo> lista = new ArrayList<>();
        String sql = "SELECT codigo, fecha, lectura_anterior, lectura_actual, consumo, codigo_medidor\n"
                + "  FROM consumo;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Consumo consumo = new Consumo();
                consumo.setCodigo(rst.getInt("codigo"));
                consumo.setFecha(rst.getDate("fecha"));
                consumo.setLecturaAnt(rst.getInt("lectura_anterior"));
                consumo.setLecturaAct(rst.getInt("lectura_actual"));
                consumo.setConsumo(rst.getDouble("consumo"));
                try {
                    ImpMedidor medidor = new ImpMedidor();
                    consumo.setMedidor(medidor.obtenerCodigo(rst.getString("codigo_medidor")));
                } catch (SQLException e) {
                    throw e;
                }
                lista.add(consumo);
            }
        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    @Override
    public int actualizar(Consumo consumo) throws Exception {
        int update = 0;
        String sql = "UPDATE consumo\n"
                + "   SET fecha=?, lectura_anterior=?, lectura_actual=?, consumo=?, \n"
                + "       codigo_medidor=?\n"
                + " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, consumo.getFecha()));
        prts.add(new Parametro(2, consumo.getLecturaAnt()));
        prts.add(new Parametro(3, consumo.getLecturaAct()));
        prts.add(new Parametro(4, consumo.getConsumo()));
        prts.add(new Parametro(5, consumo.getMedidor().getCodigo()));        
        prts.add(new Parametro(6, consumo.getCodigo()));
        try {
            update = con.querySet(sql,prts);
        } catch (Exception e) {
            throw e;
        }
        
        return update;
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete = 0;
        String sql = "DELETE FROM public.consumo\n"
                + " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            delete = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return delete;
    }

}
