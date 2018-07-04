/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.implementacion;

import ec.gob.senagua.accesodatos.Parametro;
import ec.gob.senagua.entidades.Usuario;
import ec.gob.senagua.accesodatos.Coneccion;
import ec.gob.senagua.dao.contrato.IntUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NuevoUsuario
 */
public class ImpUsuario implements IntUsuario{
    
    Coneccion con = new Coneccion();

    @Override
    public int insertar(Usuario usuario) throws Exception {
        int insert = 0;
        String sql = "INSERT INTO public.usuarios"
                + "( nombre, clave, tipo) VALUES (?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, usuario.getNombre()));
        prts.add(new Parametro(2, usuario.getClave()));
        prts.add(new Parametro(3, usuario.getTipo()));
        if (usuario.getCodigo() != 0) {
            sql = "INSERT INTO public.usuarios( nombre, clave, tipo, codigo) VALUES (?, ?, ?, ?);";
            prts.add(new Parametro(4, usuario.getCodigo()));

        }
        try {
            insert = con.querySet(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return insert;
    }

    @Override
    public Usuario obtenerCodigo(int id) throws Exception {
        Usuario usuario = null;
        String sql ="SELECT codigo, nombre, clave, tipo " +
"                    FROM public.usuarios where codigo = ?;";
       List<Parametro> prts = new ArrayList<>();
       prts.add(new Parametro(1, id));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while(rst.next()){
                usuario = new Usuario();
                usuario.setCodigo(rst.getInt("codigo"));
                usuario.setNombre(rst.getString("nombre"));
                usuario.setClave(rst.getString("clave"));
                usuario.setTipo(rst.getString("tipo"));
            }
        } catch (Exception e) {
            throw e;
        }
       return usuario;      
    }

    @Override
    public Usuario obtenerLogin(String nombre, String clave) throws Exception {
        Usuario usuario = null;
        String sql ="SELECT codigo, nombre, clave, tipo "
                + "FROM public.usuarios where nombre = ? and clave = ? ;";
       List<Parametro> prts = new ArrayList<>();
       prts.add(new Parametro(1, nombre));
       prts.add(new Parametro(2, clave));
        try {
            ResultSet rst = con.queryGet(sql, prts);
            while(rst.next()){
                usuario = new Usuario();
                usuario.setCodigo(rst.getInt("codigo"));
                usuario.setNombre(rst.getString("nombre"));
                usuario.setClave(rst.getString("clave"));
                usuario.setTipo(rst.getString("tipo"));
            }
        } catch (Exception e) {
            throw e;
        }
       return usuario; 
    }

    @Override
    public List<Usuario> obtenerTodos() throws Exception {
    List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT codigo, nombre, clave, tipo "
                + "FROM public.usuarios  order by lastname ASC";
        try {
            ResultSet rst = con.queryGet(sql);
            while (rst.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(rst.getInt("codigo"));
                usuario.setNombre(rst.getString("nombre"));
                usuario.setClave(rst.getString("clave"));
                usuario.setTipo(rst.getString("tipo"));
                usuarios.add(usuario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return usuarios;     
    }   

    @Override
    public int actualizar(Usuario usuario) throws Exception {
       int update = 0;
       String sql = "UPDATE public.usuarios " +
                    "SET codigo=?, nombre=?, clave=?, tipo=? " +
                    "WHERE codigo = ?;";
       List<Parametro> prts = new ArrayList<>();
       prts.add(new Parametro(1, usuario.getNombre()));
       prts.add(new Parametro(2, usuario.getClave()));
       prts.add(new Parametro(3, usuario.getTipo()));
        try {
            update=con.querySet(sql, prts);     
        } catch (Exception e) {
            throw e;
        }       
       return update;
    }

    @Override
    public int eliminar(int id) throws Exception {
        int delete = 0;
        String sql = "DELETE FROM public.usuarios "
                + "WHERE codigo = ?;";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, id));
        try {
            delete=con.querySet(sql, prts);     
        } catch (Exception e) {
            throw e;
        } 
        return delete;
    }

    

 
//    public ResultSet MostrarArticulos(){
//        try {
//            String sql ="SELECT * FROM articulo;";
//            sta=cnx.createStatement();
//            sta.executeQuery(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(OperacionesUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rs;
//    }
}
