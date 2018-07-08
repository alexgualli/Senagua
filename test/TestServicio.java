import ec.gob.senagua.entidades.Servicio;
import ec.gob.senagua.implementacion.ImpServicio;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paul
 */
public class TestServicio {
    
    @Test
    public void test() {
        
        ImpServicio imp = new ImpServicio();
        Servicio servicio = new Servicio();
        
        servicio.setCodigo(100);
        servicio.setCostoExc(10);
        servicio.setCostoMin(10);
        servicio.setMinimoM3(10);
        servicio.setTipoSer("nose");
        
        //INSERTAR 
        int insert =0;
        try {
            insert=imp.insertar(servicio);
            if(insert>0){
                System.out.println("INSERTADO: "+servicio.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL INSERTAR: "+e);
        }
        assertTrue(insert > 0);

        
        //ACTUALIZAR
        int update =0;
        try {
            servicio.setTipoSer("TODO");
            update=imp.actualizar(servicio);
            if(update>0){
                System.out.println("ACTUALIZADO: "+servicio.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL ACTUALIZAR: "+e);
        }
        assertTrue(update > 0);
       
        //LISTAR POR CODIGO
         Servicio servicio2 = null;
        try {
            servicio2 = imp.obtenerCodigo(100);
            System.out.println("BUSCADO POR CODIGO: " + servicio.toString());
        } catch (Exception e) {
            System.err.println("ERROR! ERROR AL BUSCAR: " + e.getMessage());
        }
        assertTrue(servicio2 != null);  
        
        //LISTAR TODOS
        List<Servicio> lista = new ArrayList<>();
        try {
            lista = imp.obtenerTodos();
            System.out.println("TODOS LOS SERVICIOS");
            for (Servicio ser : lista) {
                System.out.println("\t" + ser.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR NO SE PUDO LISTAR: "+e);
        }
        assertTrue(lista.size()>0);
        
        
        //ELIMINAR
        int delete = 0;
        try {
            delete = imp.eliminar(servicio.getCodigo());
            if (delete!=0) {
                System.out.println("ELIMINADO: " + servicio.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR: "+ e);
        }
        assertTrue(delete > 0);
        
    }
    
}
