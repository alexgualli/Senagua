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
        /*
        String sql = "INSERT INTO public.factura(codigo_cliente, codigo_usuario, observacion, estado, \n"
                + "            fecha_de_emision, total, codigo_detalle, descuento)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, factura.getCliente().getCodigo()));
        prts.add(new Parametro(2, factura.getUsuario().getCodigo()));
        prts.add(new Parametro(3, factura.getObservacion()));
        prts.add(new Parametro(4, factura.getEstado()));
        prts.add(new Parametro(5, factura.getFechaEmi()));
        prts.add(new Parametro(6, factura.getTotal()));
        prts.add(new Parametro(7, factura.getDetalle().getCodigo()));
        prts.add(new Parametro(8, factura.getDescuento()));
        if (factura.getCodigo() != 0) {
            sql = "INSERT INTO public.factura(codigo_cliente, codigo_usuario, observacion, estado, \n"
                    + "            fecha_de_emision, total, codigo_detalle, descuento, codigo)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            prts.add(new Parametro(9, factura.getCodigo()));
        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
*/
        return insert;
    }

    @Override
    public Factura obtenerCodigo(int id) throws Exception {
        Factura factura = null;
        String sql = "SELECT codigo_cliente, codigo_usuario, observacion, estado, \n"
                + "       fecha_de_emision, total, codigo_detalle, descuento\n"
                + "  FROM public.factura "
                + "WHERE codigo = ? ";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while (rst.next()) {
                factura = new Factura();
                factura.setObservacion(rst.getString("observacion"));
                factura.setEstado(rst.getString("estado"));
                factura.setFechaEmi(rst.getString("fecha_de_emision"));
                factura.setTotal(rst.getDouble("total"));
                factura.setDescuento(rst.getDouble("descuento"));
                try {
                    ImpCliente cliente = new ImpCliente();
                    ImpDetalleFactura detalle = new ImpDetalleFactura();
                    ImpUsuario usuario = new ImpUsuario();
                    
                    factura.setCliente(cliente.obtenerCodigo(rst.getInt("codigo_cliente")));
                    factura.setUsuario(usuario.obtenerCodigo(rst.getInt("codigo_usuario")));
                    factura.setDetalle(detalle.obtenerCodigo(rst.getInt("codigo_detalle")));

                } catch (Exception e) {
                    throw e;
                }

            }
        } catch (Exception e) {
            throw e;
        }
        return factura;
    }

    @Override
    public List<Factura> obtenerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Factura factura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete = 0;
        /*
        String sql = "DELETE FROM public.factura\n"
                + " WHERE codigo = ?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            delete = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
*/
        return delete;
    }

}