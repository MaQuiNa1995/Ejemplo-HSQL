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
import es.maquina1995.hsqldb.dominio.Mapa;

/**
 * Clase de test para el testo de {@link MapaService}
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
public class MapaServiceImplTest {

    private MapaService cut;

    // ----------------- Create ------------------

    @Test
    @Transactional
    public void testAniadirMapa() {
	Long idMapa = cut.aniadirMapa("Desert", 9, 8, false, 7);

	Assertions.assertNotNull(idMapa);
    }

    // ----------------- Read ------------------

    @Test
    @Transactional
    public void testObtenerMapa() {
	Long idMapa = cut.aniadirMapa("Desert", 9, 8, false, 7);

	Mapa mapa = cut.obtenerMapa(idMapa);

	Assertions.assertNotNull(mapa.getId());
	Assertions.assertTrue(mapa.getNombreMapa().equalsIgnoreCase("Desert"));
	Assertions.assertTrue(mapa.getBasesMaximo() == 9);
	Assertions.assertTrue(mapa.getJugadoresMaximo() == 8);
	Assertions.assertTrue(mapa.isJugado() == false);
    }

    @Test
    @Transactional
    public void testObtenerMapas() {

	cut.aniadirMapa("Desert", 9, 8, false, 7);
	cut.aniadirMapa("Desert2", 9, 8, false, 7);

	List<Mapa> listaMapas = cut.obtenerMapas();

	Assertions.assertFalse(listaMapas.isEmpty());
	listaMapas.forEach((mapa) -> Assertions.assertNotNull(mapa.getId()));
    }

    // ----------------- Update ------------------

    @Test
    @Transactional
    public void testActualizarMapa() {
	Long idMapa = cut.aniadirMapa("Desert", 9, 8, false, 7);

	Mapa mapa = cut.obtenerMapa(idMapa);
	mapa.setNombreMapa("Oceanic");

	Mapa mapaMod = cut.actualizarMapa(mapa);

	Assertions.assertTrue(mapaMod.getNombreMapa().equalsIgnoreCase("Oceanic"));
    }

    // ----------------- Delete ------------------

    @Test
    @Transactional
    public void testBorrarMapa() {
	Long idMapa = cut.aniadirMapa("Desert", 9, 8, false, 7);

	cut.borrarMapa(idMapa);

	List<Mapa> mapas = cut.obtenerMapas();

	Assertions.assertTrue(mapas.isEmpty());
    }

    @Autowired
    public void setMapaService(MapaService mapaService) {
	this.cut = mapaService;
    }

}
