package paintball;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Andres
 */
public class PaintballTest {

    public PaintballTest() {
    }

    /**
     * Test de metodo descargar, de la clase Paintball.
     */
    @Test
    public void testDescargarCantidadMayor0() throws Exception {
        System.out.println("testDescargarCantidadUno");
        int cantidad = 1;
        try {
            Paintball instance = new Paintball(10, 10);
            instance.descargar(cantidad);
            Assert.assertEquals(9, instance.consultar_municion_cargada());
        } catch (Exception e) {
            Assert.fail("No deberia haber lanzado ninguna excepcion");
        }
    }

    @Test
    public void testDescargarCantidadCero() throws Exception {
        System.out.println("testDescargarCantidadCero");
        int cantidad = 0;
        try {
            Paintball instance = new Paintball(1, 0);
            instance.descargar(cantidad);
            Assert.fail("No se debería poder descargar una cantidad igual a cero");
        } catch (Exception e) {
            Assert.assertEquals("No se puede descargar 0 o una cantidad negativa de municiones", e.getMessage());
        }
    }

    @Test
    public void testDescargarCantidadMenor0() throws Exception {
        System.out.println("testDescargarCantidadNegativa");
        int cantidad = -1;
        try {
            Paintball instance = new Paintball(10, 0);
            instance.descargar(cantidad);
            Assert.fail("No se ha podido descargar la munición");
        } catch (Exception e) {
            Assert.assertEquals("No se puede descargar 0 o una cantidad negativa de municiones", e.getMessage());
        }
    }

    @Test
    public void testDescargarCantidadSinCargar() throws Exception {
        System.out.println("testDescargarCantidadSinCargar");
        int cantidad = 1;
        try {
            Paintball instance = new Paintball();
            instance.descargar(cantidad);
            Assert.fail("No se debería poder descargar sin cargar previamente");
        } catch (Exception e) {
            Assert.assertEquals("No se pueden descargar más municiones de las que hay cargadas", e.getMessage());
        }
    }

    @Test
    public void testDescargarCantidadCapacidadMasUno() throws Exception {
        System.out.println("testDescargarCantidadCapacidadMasUno");
        int cantidad = 11;
        try {
            Paintball instance = new Paintball();
            instance.descargar(cantidad);
            Assert.fail("No debería poder descargar más municiones de las que hay cargadas");
        } catch (Exception e) {
            Assert.assertEquals("No se pueden descargar más municiones de las que hay cargadas", e.getMessage());
        }
    }

    @Test
    public void testDescargarCantidadIgualACapacidad() throws Exception {
        System.out.println("testDescargarCantidadIgualACapacidad");
        int cantidad = 1;
        try {
            Paintball instance = new Paintball(1, 1);
            instance.descargar(cantidad);
            Assert.fail("No se debería poder descargar cantidad de munición igual a la capacidad");
        } catch (Exception e) {
            Assert.assertEquals("No se pueden descargar más municiones de las que hay cargadas", e.getMessage());
        }
    }
    @Test
    public void testDescargarCantidadCapacidadMenosUno() throws Exception {
        System.out.println("testDescargarCantidadCapacidadMenosUno");
        int cantidad = 1;
        try {
            Paintball instance = new Paintball(2, 2);
            instance.descargar(cantidad);
            Assert.assertEquals(1, instance.consultar_municion_cargada());
        } catch (Exception e) {
            Assert.fail("No debería haber lanzado ninguna excepción");
        }
    }
}
