
import ec.gob.senagua.entidades.Consumo;
import ec.gob.senagua.entidades.Medidor;
import ec.gob.senagua.implementacion.ImpConsumo;
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
 * @author Usuario
 */
public class TestConsumo {
    
    @Test
    public void test() {
        
        ImpConsumo imp = new ImpConsumo();
        Consumo consumo = new Consumo();
        Medidor medidor = new Medidor();
        
        medidor.setCodigo("a1b2c3");
        consumo.setCodigo(300);
        consumo.setConsumo(20);
        consumo.setFecha("2010-10-10");
        consumo.setLecturaAct(10);
        consumo.setLecturaAnt(20);
        consumo.setMedidor(medidor);
        
        //INSERTAR
        int insert =0;
        try {
            insert=imp.insertar(consumo);
            if(insert>0){
                System.out.println("INSERTADO: "+consumo.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL INSERTAR: "+e);
        }
        assertTrue(insert > 0);
        
        
        //ACTUALIZAR
        int update =0;
        try {
            consumo.setLecturaAct(100);
            update=imp.actualizar(consumo);
            if(update>0){
                System.out.println("ACTUALIZADO: "+consumo.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL ACTUALIZAR: "+e);
        }
        assertTrue(update > 0);
        
        
        //LISTAR POR CODIGO
         Consumo consumo2 = null;
        try {
            consumo2 = imp.obtenerCodigo(300);
            System.out.println("BUSCADO POR CODIGO: " + consumo2.toString());
        } catch (Exception e) {
            System.err.println("ERROR! ERROR AL BUSCAR: " + e.getMessage());
        }
        assertTrue(consumo2 != null);  
        
        //LISTAR TODOS
        List<Consumo> lista = new ArrayList<>();
        try {
            lista = imp.obtenerTodos();
            System.out.println("\nTODOS LOS CONSUMOS");
            for (Consumo consu : lista) {
                System.out.println("\t" + consu.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR NO SE PUDO LISTAR: "+e);
        }
        assertTrue(lista.size()>0);
        
        
        
        //ELIMINAR
        int delete = 0;
        try {
            delete = imp.eliminar(consumo.getCodigo());
            if (delete!=0) {
                System.out.println("ELIMINADO: " + consumo.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR: "+ e);
        }
        assertTrue(delete > 0);
        
        
        
        
    }
    
}
