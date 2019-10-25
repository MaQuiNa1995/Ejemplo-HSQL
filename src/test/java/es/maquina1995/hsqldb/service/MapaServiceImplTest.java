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
import es.maquina1995.hsqldb.dominio.Mapa;
import es.maquina1995.hsqldb.repository.MapaRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class MapaServiceImplTest {

    private MapaService sut;
    private MapaRepository mapaRepository;

    @BeforeEach
    public void setUp() throws Exception {
	limpiarMapas();
    }

    @Test
    public void testAniadirBase() {
	Long idBase = sut.aniadirMapa("Desert", 9, 8, false, 7);

	Assertions.assertNotNull(idBase);
    }

    @Test
    public void testObtenerBase() {
	Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

	Mapa mapa = sut.obtenerMapa(idMapa);

	Assertions.assertNotNull(mapa.getId());
	Assertions.assertTrue(mapa.getNombreMapa().equalsIgnoreCase("Desert"));
	Assertions.assertTrue(mapa.getBasesMaximo() == 9);
	Assertions.assertTrue(mapa.getJugadoresMaximo() == 8);
	Assertions.assertTrue(mapa.isJugado() == false);
    }

    @Test
    public void testObtenerBases() {

	List<Mapa> listaMapas = sut.obtenerMapas();

	Assertions.assertFalse(listaMapas.isEmpty());
	listaMapas.forEach((mapa) -> Assertions.assertNotNull(mapa.getId()));
    }

    @Test
    public void testActualizarBase() {
	Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

	Mapa mapa = sut.obtenerMapa(idMapa);
	mapa.setNombreMapa("Oceanic");

	Mapa mapaMod = sut.obtenerMapa(idMapa);

	Assertions.assertTrue(mapaMod.getNombreMapa().equalsIgnoreCase("Oceanic"));
    }

    @Test
    public void testBorrarBase() {
	Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

	sut.borrarMapa(idMapa);

	List<Mapa> mapas = sut.obtenerMapas();

	Assertions.assertTrue(mapas.isEmpty());
    }

    private void limpiarMapas() {
	sut.obtenerMapas().forEach((base) -> mapaRepository.delete(base));
    }

    @Autowired
    public void setMapaService(MapaService sut) {
	this.sut = sut;
    }

    @Autowired
    public void setMapaRepository(MapaRepository mapaRepository) {
	this.mapaRepository = mapaRepository;
    }
}
