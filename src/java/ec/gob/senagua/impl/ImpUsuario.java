/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.impl;

import ec.gob.senagua.dao.*;
import ec.gob.senagua.entidades.Usuario;
import ec.gob.senagua.dao.Coneccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NuevoUsuario
 */
public class ImpUsuario extends Coneccion {

    public boolean insertar(Usuario a) throws Exception {
        boolean insert = false;

        String sql = "INSERT INTO public.usuarios( \"Nombre\", clave, \"Tipo\") VALUES (?, ?, ?);";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, a.getNombre()));
        prts.add(new Parametro(2, a.getPassword()));
        prts.add(new Parametro(3, a.getCargo()));
        Coneccion con = new Coneccion();

        if (a.getCodigo() != 0) {
            sql = "INSERT INTO public.usuarios( \"Nombre\", clave, \"Tipo\", \"Codigo\") VALUES (?, ?, ?, ?);";
            prts.add(new Parametro(4, a.getCodigo()));

        }

        try {
            insert = con.querySet(sql, prts);
            System.out.println(insert);
        } catch (Exception e) {
            throw e;
        }

        return insert;
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
