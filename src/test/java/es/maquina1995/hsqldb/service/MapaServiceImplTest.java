/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.maquina1995.hsqldb.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Mapa;
import es.maquina1995.hsqldb.repository.MapaRepository;
import es.maquina1995.hsqldb.serviceimpl.MapaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class})
@Transactional
public class MapaServiceImplTest {

    private MapaService sut;
    private MapaRepository mapaRepository;

	@Autowired
	public void setMapaService(MapaService sut) {
		this.sut = sut;
	}
	
	@Autowired
	public void setMapaRepository(MapaRepository mapaRepository) {
		this.mapaRepository = mapaRepository;
	}

    @Before
    public void setUp() throws Exception {
        limpiarMapas();
    }

    @Test
    public void testAniadirBase() {
        Long idBase = sut.aniadirMapa("Desert", 9, 8, false, 7);

        assertNotNull(idBase);
    }

    @Test
    public void testObtenerBase() {
        Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

        Mapa mapa = sut.obtenerMapa(idMapa);

        assertNotNull(mapa.getId());
        assertTrue(mapa.getNombreMapa().equalsIgnoreCase("Desert"));
        assertTrue(mapa.getBasesMaximo() == 9);
        assertTrue(mapa.getJugadoresMaximo() == 8);
        assertTrue(mapa.isJugado() == false);
    }

    @Test
    public void testObtenerBases() {
        List<Mapa> mapas = sut.obtenerMapas();
        mapas.forEach((mapa) -> {
            assertNotNull(mapa.getId());
        });
    }

    @Test
    public void testActualizarBase() {
        Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

        Mapa mapa = sut.obtenerMapa(idMapa);
        mapa.setNombreMapa("Oceanic");

        Mapa mapaMod = sut.obtenerMapa(idMapa);

        assertTrue(mapaMod.getNombreMapa().equalsIgnoreCase("Oceanic"));
    }

    @Test
    public void testBorrarBase() {
        Long idMapa = sut.aniadirMapa("Desert", 9, 8, false, 7);

        sut.borrarMapa(idMapa);

        List<Mapa> mapas = sut.obtenerMapas();

        assertTrue(mapas.isEmpty());
    }

    private void limpiarMapas() {
        List<Mapa> bases = sut.obtenerMapas();
        bases.forEach((base) -> {
            mapaRepository.delete(base);
        });
    }
}
