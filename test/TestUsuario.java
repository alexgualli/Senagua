
import ec.gob.senagua.entidades.Usuario;
import ec.gob.senagua.impl.ImpUsuario;
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


public class TestUsuario {
    
    @Test
    public void test() {
        
        ImpUsuario user = new ImpUsuario();
        Usuario u = new Usuario();
        
        u.setCodigo(10);
        u.setNombre("alex");
        u.setCargo("lolo");
        u.setPassword("1234");
        
        boolean insert =false;
        try {
            
            if(user.insertar(u)){
                System.out.println("insertado"+u.toString());
                insert = true;
            }                      
        } catch (Exception e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
        
        assertTrue(insert);
    }
  

    
    
}
