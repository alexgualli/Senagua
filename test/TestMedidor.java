
import ec.gob.senagua.entidades.Cliente;
import ec.gob.senagua.entidades.Medidor;
import ec.gob.senagua.implementacion.ImpMedidor;
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
public class TestMedidor {
    
    @Test
    public void test() {
        
        ImpMedidor imp = new ImpMedidor();
        
        Cliente cliente = new Cliente();
        Medidor medidor = new Medidor();
        
        cliente.setCodigo(1);
        
        medidor.setCliente(cliente);
        medidor.setCodigo("100");
        medidor.setTipoMed("nada");
        
        //INSERTAR 
        int insert = 0;
         try {
             insert=imp.insertar(medidor);
             if(insert>0){
                System.out.println("INSERTADO: "+medidor.toString());                
            }                      
        } catch (Exception e) {
            System.err.println("¡ERROR! ERROR AL INSERTAR: " + e.getMessage());
        }        
        assertTrue(insert>0);
        
        //ACTUALIZAR
        int update = 0;
         try {
             medidor.setTipoMed("TODO");
             update=imp.actualizar(medidor);
             if(update>0){
                System.out.println("ACTUALIZADO: "+medidor.toString());                
            }                      
        } catch (Exception e) {
            System.err.println("¡ERROR! ERROR AL ACTUALIZAR: " + e.getMessage());
        }        
         assertTrue(update>0);
        
         //LISTAR POR CODIGO
         Medidor medidor2 = null;
        try {
            medidor2 = imp.obtenerCodigo("100");
            System.out.println("BUSCADO POR CODIGO: " + medidor2.toString());
        } catch (Exception e) {
            System.err.println("ERROR! ERROR AL BUSCAR: " + e.getMessage());
        }
        assertTrue(medidor2 != null);       
        
        //LISTAR TODOS
        List<Medidor> lista = new ArrayList<>();
        try {
            lista = imp.obtenerTodos();
            System.out.println("TODOS LOS MEDIDORES");
            for (Medidor medi : lista) {
                System.out.println("\t" + medi.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NINGUN CLIENTE ENCONTRADO: " +e);
        }
        assertTrue(lista.size() >0);
        
        
        
        //ELIMINAR
        int delete = 0;
        try {
            delete = imp.eliminar(medidor.getCodigo());
            if (delete!=0) {
                System.out.println("ELIMINADO: " + medidor.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR: "+ e);
        }
        assertTrue(delete >= 0);
        
        
        
    }
    
}
