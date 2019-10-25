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

    private TrabajadorService sut;
    private TrabajadorRepository trabajadorRepository;

    public void setSut(TrabajadorService sut) {
	this.sut = sut;
    }

    @BeforeEach
    public void setUp() throws Exception {
	limpiarTrabajadores();
    }

    @Test
    public void testAniadirTrabajador() {
	Long idTrabajador = sut.aniadirTrabajador("Sonda");

	Assertions.assertNotNull(idTrabajador);
    }

    @Test
    public void testObtenerTrabajador() {
	Long idTrabajador = sut.aniadirTrabajador("Sonda");

	Trabajador trabajador = sut.obtenerTrabajador(idTrabajador);

	Assertions.assertNotNull(trabajador.getId());
	Assertions.assertTrue(trabajador.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testObtenerTrabajadors() {
	List<Trabajador> listaTrabajadores = sut.obtenerTrabajadores();

	Assertions.assertFalse(listaTrabajadores.isEmpty());
	listaTrabajadores.forEach((trabajador) -> Assertions.assertNotNull(trabajador.getId()));
    }

    @Test
    public void testActualizarTrabajador() {
	Long idTrabajador = sut.aniadirTrabajador("Sonda");

	Trabajador trabajador = sut.obtenerTrabajador(idTrabajador);
	trabajador.setTipoTrabajador("Sonda");

	Trabajador trabajadorMod = sut.obtenerTrabajador(idTrabajador);

	Assertions.assertTrue(trabajadorMod.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testBorrarTrabajador() {
	Long idTrabajador = sut.aniadirTrabajador("Sonda");

	sut.borrarTrabajador(idTrabajador);

	List<Trabajador> trabajadors = sut.obtenerTrabajadores();

	Assertions.assertTrue(trabajadors.isEmpty());
    }

    private void limpiarTrabajadores() {
	sut.obtenerTrabajadores().forEach((base) -> trabajadorRepository.delete(base));
    }

    @Autowired
    public void setMapaService(TrabajadorService sut) {
	this.sut = sut;
    }

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
	this.trabajadorRepository = trabajadorRepository;
    }
}
