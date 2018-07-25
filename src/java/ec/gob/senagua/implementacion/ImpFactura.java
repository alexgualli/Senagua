/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntFactura;
import ec.gob.senagua.entidades.Factura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class ImpFactura implements IntFactura {

    Coneccion con = new Coneccion();

    @Override
    public int insertar(Factura factura) throws Exception {
        int insert = 0;
        String sql = "INSERT INTO public.factura(codigo_cliente, codigo_usuario, observacion, estado, \n"
                + "            fecha_de_emision, total, descuento, codigo_medidor)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, factura.getCliente().getCodigo()));
        prts.add(new Parametro(2, factura.getUsuario().getCodigo()));
        prts.add(new Parametro(3, factura.getObservacion()));
        prts.add(new Parametro(4, factura.getEstado()));
        prts.add(new Parametro(5, factura.getFechaEmi()));
        prts.add(new Parametro(6, factura.getTotal()));
        prts.add(new Parametro(7, factura.getDescuento()));
        prts.add(new Parametro(8, factura.getMedidor().getCodigo()));

        if (factura.getCodigo() != 0) {
            sql = "INSERT INTO public.factura(codigo_cliente, codigo_usuario, observacion, estado, \n"
                    + "            fecha_de_emision, total, descuento, codigo_medidor, codigo)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            prts.add(new Parametro(9, factura.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }

        return insert;
    }

    @Override
    public Factura obtenerCodigo(int id) throws Exception {

        ImpCliente cliente = new ImpCliente();
        ImpUsuario usuario = new ImpUsuario();
        ImpMedidor medidor = new ImpMedidor();

        Factura factura = null;
        String sql = "SELECT codigo, codigo_cliente, codigo_usuario, observacion, estado, \n"
                + "       fecha_de_emision, total, descuento, codigo_medidor\n"
                + "  FROM factura where codigo=? ";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
                factura = new Factura();
                factura.setCodigo(rst.getInt("codigo"));
                factura.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                factura.setUsuario(usuario.obtenerCodigo(rst.getInt("codigo_usuario")));
                factura.setObservacion(rst.getString("observacion"));
                factura.setEstado(rst.getString("estado"));
                factura.setFechaEmi(rst.getString("fecha_de_emision"));
                factura.setTotal(rst.getDouble("total"));
                factura.setDescuento(rst.getDouble("descuento"));
                factura.setMedidor(medidor.obtenerCodigo(rst.getString("codigo_medidor")));
            }
        } catch (Exception e) {
            throw e;
        }
        return factura;
    }

    @Override
    public List<Factura> obtenerTodos() throws Exception {

        ImpCliente cliente = new ImpCliente();
        ImpUsuario usuario = new ImpUsuario();
        ImpMedidor medidor = new ImpMedidor();

        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT codigo, codigo_cliente, codigo_usuario, observacion, estado, "
                + "       fecha_de_emision, total, descuento, codigo_medidor"
                + "  FROM public.factura order by fecha_de_emision ASC;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Factura factura = new Factura();
                factura.setCodigo(rst.getInt("codigo"));
                factura.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                factura.setUsuario(usuario.obtenerCodigo(rst.getInt("codigo_usuario")));
                factura.setObservacion(rst.getString("observacion"));
                factura.setEstado(rst.getString("estado"));
                factura.setFechaEmi(rst.getString("fecha_de_emision"));
                factura.setTotal(rst.getDouble("total"));
                factura.setDescuento(rst.getDouble("descuento"));
                factura.setMedidor(medidor.obtenerCodigo(rst.getString("codigo_medidor")));
                lista.add(factura);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

        return lista;
    }

    @Override
    public int actualizar(Factura factura) throws Exception {
        int update = 0;
        String sql = "UPDATE public.factura\n"
                + "   SET codigo_cliente=?, codigo_usuario=?, observacion=?, \n"
                + "       estado=?, fecha_de_emision=?, total=?, descuento=?, codigo_medidor=? \n"
                + " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, factura.getCliente().getCodigo()));
        prts.add(new Parametro(2, factura.getUsuario().getCodigo()));
        prts.add(new Parametro(3, factura.getObservacion()));
        prts.add(new Parametro(4, factura.getEstado()));
        prts.add(new Parametro(5, factura.getFechaEmi()));
        prts.add(new Parametro(6, factura.getTotal()));
        prts.add(new Parametro(7, factura.getDescuento()));
        prts.add(new Parametro(8, factura.getMedidor().getCodigo()));
        prts.add(new Parametro(9, factura.getCodigo()));
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
        String sql = "DELETE FROM factura "
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

    @Override
    public List<Factura> obtenerMedidor(String dato) throws Exception {
        ImpCliente cliente = new ImpCliente();
        ImpUsuario usuario = new ImpUsuario();
        ImpMedidor medidor = new ImpMedidor();

        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT codigo, codigo_cliente, codigo_usuario, observacion, estado, "
                + "       fecha_de_emision, total, descuento, codigo_medidor"
                + "  FROM public.factura "
                + "WHERE codigo_medidor='"+dato+"'"
                + " order by fecha_de_emision ASC;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Factura factura = new Factura();
                factura.setCodigo(rst.getInt("codigo"));
                factura.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                factura.setUsuario(usuario.obtenerCodigo(rst.getInt("codigo_usuario")));
                factura.setObservacion(rst.getString("observacion"));
                factura.setEstado(rst.getString("estado"));
                factura.setFechaEmi(rst.getString("fecha_de_emision"));
                factura.setTotal(rst.getDouble("total"));
                factura.setDescuento(rst.getDouble("descuento"));
                factura.setMedidor(medidor.obtenerCodigo(rst.getString("codigo_medidor")));
                lista.add(factura);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

        return lista;
    }

}
