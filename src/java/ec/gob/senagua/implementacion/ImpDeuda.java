/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntDeuda;
import ec.gob.senagua.entidades.Deuda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class ImpDeuda implements IntDeuda {

    Coneccion con = new Coneccion();

    @Override
    public int insertar(Deuda deuda) throws Exception {
        int insert = 0;
        String sql = "INSERT INTO public.deudas(valor, codigo_cliente, codigo_factura, meses_pendientes)\n"
                + "    VALUES (?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, deuda.getValor()));
        prts.add(new Parametro(2, deuda.getCliente().getCodigo()));
        prts.add(new Parametro(3, deuda.getFactura().getCodigo()));
        prts.add(new Parametro(4, deuda.getMesesPen()));
        if (deuda.getCodigo() != 0) {
            sql = "INSERT INTO public.deudas(valor, codigo_cliente, codigo_factura, meses_pendientes, codigo)\n"
                    + "    VALUES (?, ?, ?, ?, ?);";
            prts.add(new Parametro(5, deuda.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return insert;
    }

    @Override
    public Deuda obtenerCodigo(int id) throws Exception {

        Deuda deuda = null;
        String sql = "SELECT valor, codigo_cliente, codigo_factura, meses_pendientes "
                + "  FROM public.deudas "
                + "WHERE codigo = ?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
                deuda = new Deuda();
                deuda.setCodigo(rst.getInt("codigo"));
                deuda.setValor(rst.getDouble("valor"));
                deuda.setMesesPen(rst.getInt("meses_pendientes"));
                try {
                    ImpCliente cliente = new ImpCliente();
                    ImpFactura factura = new ImpFactura();

                    deuda.setFactura(factura.obtenerCodigo(rst.getInt("codigo_factura")));
                    deuda.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return deuda;
    }

    @Override
    public List<Deuda> obtenerTodos() throws Exception {
        List<Deuda> lista = new ArrayList<>();
        String sql = "SELECT valor, codigo_cliente, codigo_factura, meses_pendientes, codigo\n"
                + "  FROM public.deudas;";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Deuda deuda = new Deuda();
                deuda.setCodigo(rst.getInt("codigo"));
                deuda.setValor(rst.getDouble("valor"));
                deuda.setMesesPen(rst.getInt("meses_pendientes"));
                try {
                    ImpCliente cliente = new ImpCliente();
                    ImpFactura factura = new ImpFactura();

                    deuda.setFactura(factura.obtenerCodigo(rst.getInt("codigo_factura")));
                    deuda.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                } catch (Exception e) {
                    throw e;
                }
                lista.add(deuda);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public int actualizar(Deuda deuda) throws Exception {
        int update = 0;
        String sql = "UPDATE public.deudas\n"
                + "   SET valor=?, codigo_cliente=?, codigo_factura=?, meses_pendientes=? "
                + " WHERE codigo=?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, deuda.getValor()));
        prts.add(new Parametro(2, deuda.getCliente().getCodigo()));
        prts.add(new Parametro(3, deuda.getFactura().getCodigo()));
        prts.add(new Parametro(4, deuda.getMesesPen()));
        prts.add(new Parametro(5, deuda.getCodigo()));
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
        String sql = "DELETE FROM public.deudas\n"
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
