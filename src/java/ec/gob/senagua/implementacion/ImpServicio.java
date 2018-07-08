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
import java.sql.SQLException;
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
        int insert = 0;
        String sql = "INSERT INTO public.servicio(tipo_de_servicio, costo_minimo, minimo_m3, costo_excedente)\n"
                + "    VALUES (?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, servicio.getTipoSer()));
        prts.add(new Parametro(2, servicio.getCostoMin()));
        prts.add(new Parametro(3, servicio.getMinimoM3()));
        prts.add(new Parametro(4, servicio.getCostoExc()));
        if (servicio.getCodigo() != 0) {
            sql = "INSERT INTO public.servicio(tipo_de_servicio, costo_minimo, minimo_m3, costo_excedente, codigo)\n"
                    + "    VALUES (?, ?, ?, ?, ?);";
            prts.add(new Parametro(5, servicio.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return insert;

    }

    @Override
    public Servicio obtenerCodigo(int id) throws Exception {
        Servicio servicio = null;
        String sql = "SELECT codigo, tipo_de_servicio, costo_minimo, minimo_m3, costo_excedente\n"
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
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT codigo, tipo_de_servicio, costo_minimo, minimo_m3, costo_excedente\n"
                + "  FROM public.servicio;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Servicio servicio = new Servicio();
                servicio.setCodigo(rst.getInt("codigo"));
                servicio.setTipoSer(rst.getString("tipo_de_servicio"));
                servicio.setCostoMin(rst.getDouble("costo_minimo"));
                servicio.setMinimoM3(rst.getDouble("minimo_m3"));
                servicio.setCostoExc(rst.getDouble("costo_excedente"));
                lista.add(servicio);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public int actualizar(Servicio servicio) throws Exception {
        int update = 0;
        String sql = "UPDATE public.servicio\n"
                + "   SET tipo_de_servicio=?, costo_minimo=?, minimo_m3=?, costo_excedente=? "
                + "WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, servicio.getTipoSer()));
        prts.add(new Parametro(2, servicio.getCostoMin()));
        prts.add(new Parametro(3, servicio.getMinimoM3()));
        prts.add(new Parametro(4, servicio.getCostoExc()));
        prts.add(new Parametro(5, servicio.getCodigo()));
        try {
            update = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return update;
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete = 0;
        String sql = "DELETE FROM public.servicio "
                + "WHERE codigo = ?;";
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
