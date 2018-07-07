
import ec.gob.senagua.entidades.Consumo;
import ec.gob.senagua.entidades.DetalleFactura;
import ec.gob.senagua.entidades.Factura;
import ec.gob.senagua.entidades.Servicio;
import ec.gob.senagua.implementacion.ImpDetalleFactura;
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
public class TestDetalleFactura {
    
    @Test
    public void test() {
        
        ImpDetalleFactura imp = new ImpDetalleFactura();
        DetalleFactura detalle = new DetalleFactura();
        Consumo consumo = new Consumo();
        Factura factura = new Factura();
        Servicio servicio = new Servicio();
        
        consumo.setCodigo(4);
        factura.setCodigo(1);
        servicio.setCodigo(1);
        
        detalle.setCodigo(100);
        detalle.setConsumo(consumo);
        detalle.setConsumoAct(20);
        detalle.setConsumoAnt(20);
        detalle.setCostoExc(20);
        detalle.setCostoMin(20);
        detalle.setDescripcion("nada");
        detalle.setFactura(factura);
        detalle.setM3Exc(20);
        detalle.setM3Min(20);
        detalle.setServicio(servicio);
        detalle.setSubtotal(20);
        detalle.setValorConsumo(20);
        detalle.setValorM3Exc(20);
        

        
          //INSERTAR 
        int insert =0;
        try {
            insert=imp.insertar(detalle);
            if(insert>0){
                System.out.println("INSERTADO: "+detalle.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL INSERTAR: "+e);
        }
        assertTrue(insert > 0);

        
        //ACTUALIZAR
        int update =0;
        try {
            detalle.setDescripcion("TODO");
            update=imp.actualizar(detalle);
            if(update>0){
                System.out.println("ACTUALIZADO: "+detalle.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR AL ACTUALIZAR: "+e);
        }
        assertTrue(update > 0);
       
        //LISTAR POR CODIGO
         DetalleFactura detalle2 = null;
        try {
            detalle2 = imp.obtenerCodigo(100);
            System.out.println("BUSCADO POR CODIGO: " + detalle2.toString());
        } catch (Exception e) {
            System.err.println("ERROR! ERROR AL BUSCAR: " + e.getMessage());
        }
        assertTrue(detalle2 != null);  
        
        //LISTAR TODOS
        List<DetalleFactura> lista = new ArrayList<>();
        try {
            lista = imp.obtenerTodos();
            System.out.println("TODOS LOS CONSUMOS");
            for (DetalleFactura deta : lista) {
                System.out.println("\t" + deta.toString());
            }
        } catch (Exception e) {
            System.out.println("¡ERROR! ERROR NO SE PUDO LISTAR: "+e);
        }
        assertTrue(lista.size()>0);
        
        //ELIMINAR
        int delete = 0;
        try {
            delete = imp.eliminar(detalle.getCodigo());
            if (delete!=0) {
                System.out.println("ELIMINADO: " + detalle.toString());
            }
        } catch (Exception e) {
            System.err.println("¡ERROR! NO SE PUDO ELIMINAR: "+ e);
        }
        assertTrue(delete > 0);
        
    }
    
}
