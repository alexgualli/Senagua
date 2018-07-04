
import ec.gob.senagua.entidades.Consumo;
import ec.gob.senagua.entidades.Medidor;
import ec.gob.senagua.implementacion.ImpConsumo;
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
        
        medidor.getCodigo();
        consumo.setCodigo(300);
        consumo.setConsumo(20);
        consumo.setFecha("2018-10-10");
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
