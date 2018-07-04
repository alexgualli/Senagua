/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.dao.contrato.IntCliente;
import ec.gob.senagua.entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class ImpCliente implements IntCliente{
    
    Coneccion con = new Coneccion();

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int insert=0;
        String sql ="INSERT INTO public.clientes"
                + "(nombre, apellido, direccion, cedula, correo, fecha_nac, codigo_discapacidad)" +
                    " VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, cliente.getNombre()));
        prts.add(new Parametro(2, cliente.getApellido()));
        prts.add(new Parametro(3, cliente.getDireccion()));
        prts.add(new Parametro(4, cliente.getCedula()));
        prts.add(new Parametro(5, cliente.getCorreo()));
        prts.add(new Parametro(6, cliente.getFechaNac()));
        prts.add(new Parametro(7, cliente.getCodigoDis()));
        if(cliente.getCodigo() != 0){
            sql ="INSERT INTO public.clientes"
               + "(nombre, apellido, direccion, cedula, correo, fecha_nac, codigo_discapacidad, codigo)" +
                 " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
            prts.add(new Parametro(8, cliente.getCodigo()));
        }
        try {
            insert=con.querySet(sql, prts);
            
        } catch (Exception e) {
            throw e;
        }
        
        return insert;
    }

    @Override
    public Cliente obtenerCodigo(int id) throws Exception {
        Cliente cliente = null;
        String sql ="SELECT nombre, apellido, direccion, cedula, correo, fecha_nac, codigo_discapacidad " +
"                   FROM public.clientes "
                + "WHERE codigo = ? ";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while(rst.next()){
                cliente = new Cliente();
                cliente.setNombre(rst.getString("nombre"));
                cliente.setApellido(rst.getString("apellido"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setCedula(rst.getString("cedula"));
                cliente.setCorreo(rst.getString("correo"));
                cliente.setFechaNac(rst.getString("fecha_nac"));
                cliente.setCodigoDis(rst.getInt("codigo_discapacidad"));
            }
        } catch (Exception e) {
            throw e;
        }       
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String sql ="SELECT codigo, nombre, apellido, direccion, cedula, correo, fecha_nac, codigo_discapacidad "
                + "FROM public.clientes";
        try {
            ResultSet rst = con.queryGet(sql);
            while(rst.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rst.getInt("codigo"));
                cliente.setNombre(rst.getString("nombre"));
                cliente.setApellido(rst.getString("apellido"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setCedula(rst.getString("cedula"));
                cliente.setCorreo(rst.getString("correo"));
                cliente.setFechaNac(rst.getString("fecha_nac"));
                cliente.setCodigoDis(rst.getInt("codigo_discapacidad"));
                lista.add(cliente);               
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }        
        return lista;
       }

    @Override
    public int actualizar(Cliente cliente) throws Exception {
        int update =0;
        String sql="UPDATE public.clientes\n" +
                    "   SET nombre=?, apellido=?, direccion=?, cedula=?, correo=?, fecha_nac=?, codigo_discapacidad=?" +
                    " WHERE codigo = ?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, cliente.getNombre()));
        prts.add(new Parametro(2, cliente.getApellido()));
        prts.add(new Parametro(3, cliente.getDireccion()));
        prts.add(new Parametro(4, cliente.getCedula()));
        prts.add(new Parametro(5, cliente.getCorreo()));
        prts.add(new Parametro(6, cliente.getFechaNac()));
        prts.add(new Parametro(7, cliente.getCodigoDis()));
        prts.add(new Parametro(8, cliente.getCodigo()));
        try {
            update=con.querySet(sql, prts);     
        } catch (Exception e) {
            throw e;
        }       
       return update;
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete =0;
        String sql ="DELETE FROM public.clientes\n" +
                    " WHERE codigo = ?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            delete=con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return delete;
    }
    
}
