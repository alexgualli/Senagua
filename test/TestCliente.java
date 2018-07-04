

import ec.gob.senagua.entidades.Cliente;
import ec.gob.senagua.implementacion.ImpCliente;
import java.sql.Date;
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
public class TestCliente {    
    
     @Test
    public void test() {
        
        ImpCliente imp = new ImpCliente();
        Cliente cliente = null;
        
        //cliente= new Cliente(100, "alex", "gualli", "dolorosa", "0604405357", "alex.gualli.ga@gmail.com", new Date(1997, 10, 5), 10);
        
        
        cliente.setCodigo(200);
        cliente.setNombre("Sin");
        cliente.setApellido("Cuello");
        cliente.setCedula("0604405357");
        cliente.setCodigoDis(10);
        cliente.setCorreo("sincuello@gmail.com");
        cliente.setDireccion("la dolo");
        cliente.setFechaNac(new Date(1997, 10, 5));
        
        //INSERTAR 
        int insert = 0;
         try {
             insert=imp.insertar(cliente);
             if(insert!=0){
                System.out.println("Insertado: "+cliente.toString());                
            }                      
        } catch (Exception e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }        
        assertTrue(insert>0);
        
        
        
    }
    
    
}
