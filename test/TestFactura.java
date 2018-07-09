
import ec.gob.senagua.entidades.Cliente;
import ec.gob.senagua.entidades.DetalleFactura;
import ec.gob.senagua.entidades.Factura;
import ec.gob.senagua.entidades.Usuario;
import ec.gob.senagua.implementacion.ImpFactura;
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
public class TestFactura {

    @Test
    public void test() {

        ImpFactura imp = new ImpFactura();

        Cliente cliente = new Cliente();
        Factura factura = new Factura();
        DetalleFactura detalle = new DetalleFactura();
        Usuario usuario = new Usuario();

        cliente.setCodigo(1);
        detalle.setCodigo(1);
        usuario.setCodigo(1);
        
        factura.setCodigo(100);
        factura.setCliente(cliente);
        factura.setDescuento(10);
        factura.setEstado("nada");
        factura.setFechaEmi("2018-10-10");
        factura.setObservacion("nada");
        factura.setTotal(10);
        factura.setUsuario(usuario);

        //INSERTAR 
        int insert = 0;
        try {
            insert = imp.insertar(factura);
            if (insert > 0) {
                System.out.println("INSERTADO: " + factura.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL INSERTAR: " + e);
        }
        assertTrue(insert > 0);

        //ACTUALIZAR
        int update = 0;
        try {
            factura.setObservacion("TODO");
            update = imp.actualizar(factura);
            if (update > 0) {
                System.out.println("ACTUALIZADO: " + factura.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL ACTUALIZAR: " + e);
        }
        assertTrue(update > 0);
        
         //LISTAR POR CODIGO
         Factura factura2 = new Factura();
         
        try {
            factura2 = imp.obtenerCodigo(100);
            System.out.println("BUSCADO POR CODIGO: " + factura2.getTotal());
        } catch (Exception e) {
            System.err.println("ERROR! ERROR AL BUSCAR: " + e.getMessage());
        }
        assertTrue(factura2 != null);  
        
        //LISTAR TODOS
        List<Factura> lista = new ArrayList<>();
        try {
            lista = imp.obtenerTodos();
            System.out.println("TODOS LASA FACTURAS");
            for (Factura fac : lista) {
                System.out.println("\t" + fac.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR NO SE PUDO LISTAR: "+e);
        }
        assertTrue(lista.size()>0);
        

        //ELIMINAR
        int delete = 0;
        try {
            delete = imp.eliminar(factura.getCodigo());
            if (delete != 0) {
                System.out.println("ELIMINADO: " + factura.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR: " + e);
        }
        assertTrue(delete > 0);
        

    }

}
