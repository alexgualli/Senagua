import ec.gob.senagua.entidades.Usuario;
import ec.gob.senagua.implementacion.ImpUsuario;
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


public class TestUsuario {
    
    @Test
    public void test() {
        
        ImpUsuario user = new ImpUsuario();
        Usuario usuario = new Usuario();
        
        usuario.setCodigo(100);
        usuario.setNombre("alex");
        usuario.setTipo("lolo");
        usuario.setClave("1234");
   
        
        //INSERTAR
        int insert =0;
        try {
            insert = user.insertar(usuario);
            if(insert!=0){
                System.out.println("Insertado: "+usuario.toString());                
            }                      
        } catch (Exception e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }        
        assertTrue(insert>0);
        
        //ACTUALIZAR 
        int update = 0;
        try {
            usuario.setTipo("Administradofg");            
            update=user.actualizar(usuario);
            if (update!=0) {
                System.out.println("ACTUALIZADO : " + usuario.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ACTUALIZAR");
        }
        assertTrue(update>0);
        
        
        //LISTAR POR CODIGO
        usuario = null;
        try {
            usuario = user.obtenerCodigo(100);
            System.out.println("Buscado por Codigo: " + usuario.toString());
        } catch (Exception e) {
            System.err.println("ERROR! al buscar " + e.getMessage());
        }
        assertTrue(usuario != null);
        
        //LISTAR POR LOGIN
        usuario = null;
        try {
            usuario = user.obtenerLogin("alex", "1234");
            System.out.println("Buscado por Login: " + usuario.toString());
        } catch (Exception e) {
            System.err.println("ERROR! al buscar " + e.getMessage());
        }
        assertTrue(usuario != null);
        
        //LISTAR TODOS
        List<Usuario> lista = new ArrayList<>();
        try {
            lista = user.obtenerTodos();
            System.out.println("\n TODOS LOS USUARIOS");
            for (Usuario tmp : lista) {
                System.out.println("\t" + tmp.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NINGUN USUARIO ENCONTRADO");
        }
        assertTrue(lista != null);
        
        
        
        
        //ELIMINAR
        int delete = 0;
        try {
            delete = user.eliminar(usuario.getCodigo());
            if (delete!=0) {
                System.out.println("ELIMINADO: " + usuario.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR");
        }
        assertTrue(delete >= 0);

    }
  
    
    
}