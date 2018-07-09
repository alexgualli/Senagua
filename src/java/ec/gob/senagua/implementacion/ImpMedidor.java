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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ImpMedidor implements IntMedidor {

    Coneccion con = new Coneccion();

    @Override
    public int insertar(Medidor medidor) throws Exception {
        int insert = 0;
        String sql = "INSERT INTO public.medidor(codigo_cliente, tipo_de_medidor)\n"
                + "    VALUES (?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, medidor.getCliente().getCodigo()));
        prts.add(new Parametro(2, medidor.getTipoMed()));
        if (medidor.getCodigo() != null) {
            sql = "INSERT INTO public.medidor(codigo_cliente, tipo_de_medidor, codigo)\n"
                    + "    VALUES (?, ?, ?);";
            prts.add(new Parametro(3, medidor.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return insert;
    }

    @Override
    public Medidor obtenerCodigo(String id) throws Exception {
        Medidor medidor = null;
        String sql = "SELECT codigo, codigo_cliente, tipo_de_medidor\n"
                + "  FROM medidor "
                + "WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
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
        List<Medidor> lista = new ArrayList<>();
        String sql = "SELECT codigo, codigo_cliente, tipo_de_medidor\n"
                + "  FROM public.medidor;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Medidor medidor = new Medidor();
                medidor.setCodigo(rst.getString("codigo"));
                medidor.setTipoMed(rst.getString("tipo_de_medidor"));
                try {
                    ImpCliente cliente = new ImpCliente();

                    medidor.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                } catch (Exception e) {
                    throw e;
                }
                lista.add(medidor);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public int actualizar(Medidor medidor) throws Exception {
        int update = 0;
        String sql = "UPDATE public.medidor\n"
                + "   SET codigo_cliente=?, tipo_de_medidor=?\n"
                + " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, medidor.getCliente().getCodigo()));
        prts.add(new Parametro(2, medidor.getTipoMed()));
        prts.add(new Parametro(3, medidor.getCodigo()));
        try {
            update = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return update;
    }

    @Override
    public int eliminar(String id) throws Exception {
        int delete = 0;
        String sql = "DELETE FROM public.medidor\n"
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
