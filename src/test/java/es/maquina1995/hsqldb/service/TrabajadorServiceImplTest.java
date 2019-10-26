package es.maquina1995.hsqldb.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Trabajador;

/**
 * Clase de test para el testo de {@link TrabajadorService}
 * <p>
 * Lecciones Aprendidas:
 * <p>
 * Si pones {@link Transactional} a los test harán rollback automático y no
 * interferirán los datos que no borraste de otros test en los demás se usa en
 * conjunto con {@link TransactionalTestExecutionListener}
 * 
 * @author MaQuiNa1995
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class TrabajadorServiceImplTest {

    private TrabajadorService cut;

    // ----------------- Create ------------------

    @Test
    public void testAniadirTrabajador() {
	Long idTrabajador = cut.aniadirTrabajador("Sonda");
	Assertions.assertNotNull(idTrabajador);
    }

    // ----------------- Update ------------------

    @Test
    @Transactional
    public void testActualizarTrabajador() {
	
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	Trabajador trabajador = cut.obtenerTrabajador(idTrabajador);
	trabajador.setTipoTrabajador("Sonda2");

	Trabajador trabajadorMod = cut.obtenerTrabajador(idTrabajador);

	Assertions.assertEquals("Sonda2", trabajadorMod.getTipoTrabajador());
    }

    @Test
    @Transactional
    public void testObtenerTrabajador() {
	
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	Trabajador trabajador = cut.obtenerTrabajador(idTrabajador);

	Assertions.assertNotNull(trabajador.getId());
	Assertions.assertEquals("Sonda", trabajador.getTipoTrabajador());
    }

    // ----------------- Read ------------------

    @Test
    @Transactional
    public void testObtenerTrabajadores() {

	cut.aniadirTrabajador("Curro");
	List<Trabajador> listaTrabajadores = cut.obtenerTrabajadores();

	Assertions.assertFalse(listaTrabajadores.isEmpty());
	listaTrabajadores.forEach((trabajador) -> Assertions.assertNotNull(trabajador.getId()));
    }

    // ----------------- Delete ------------------

    @Test
    @Transactional
    public void testBorrarTrabajador() {
	
	Long idTrabajador = cut.aniadirTrabajador("Sonda");
	Assertions.assertFalse(cut.obtenerTrabajadores().isEmpty());

	cut.borrarTrabajador(idTrabajador);
	Assertions.assertTrue(cut.obtenerTrabajadores().isEmpty());
    }

    @Autowired
    public void setTrabajadorService(TrabajadorService trabajadorService) {
	this.cut = trabajadorService;
    }

}
