package es.maquina1995.hsqldb.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class TrabajadorServiceImplTest {

    private TrabajadorService cut;
    private TrabajadorRepository trabajadorRepository;

    @BeforeEach
    public void setUp() {
	limpiarTrabajadores();
    }

    @Test
    public void testAniadirTrabajador() {
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	Assertions.assertNotNull(idTrabajador);
    }

    @Test
    public void testObtenerTrabajador() {
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	Trabajador trabajador = cut.obtenerTrabajador(idTrabajador);

	Assertions.assertNotNull(trabajador.getId());
	Assertions.assertTrue(trabajador.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testObtenerTrabajadors() {
	List<Trabajador> listaTrabajadores = cut.obtenerTrabajadores();

	Assertions.assertFalse(listaTrabajadores.isEmpty());
	listaTrabajadores.forEach((trabajador) -> Assertions.assertNotNull(trabajador.getId()));
    }

    @Test
    public void testActualizarTrabajador() {
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	Trabajador trabajador = cut.obtenerTrabajador(idTrabajador);
	trabajador.setTipoTrabajador("Sonda");

	Trabajador trabajadorMod = cut.obtenerTrabajador(idTrabajador);

	Assertions.assertTrue(trabajadorMod.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testBorrarTrabajador() {
	Long idTrabajador = cut.aniadirTrabajador("Sonda");

	cut.borrarTrabajador(idTrabajador);

	List<Trabajador> trabajadors = cut.obtenerTrabajadores();

	Assertions.assertTrue(trabajadors.isEmpty());
    }

    private void limpiarTrabajadores() {
	cut.obtenerTrabajadores().forEach((base) -> trabajadorRepository.delete(base));
    }

    @Autowired
    public void setTrabajadorService(TrabajadorService trabajadorService) {
	this.cut = trabajadorService;
    }

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
	this.trabajadorRepository = trabajadorRepository;
    }
}
