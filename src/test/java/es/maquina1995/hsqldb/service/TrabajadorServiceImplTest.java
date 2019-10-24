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
import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;
import es.maquina1995.hsqldb.service.TrabajadorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class})
@Transactional
public class TrabajadorServiceImplTest {

    private TrabajadorService sut;
    private TrabajadorRepository trabajadorRepository;
    
	@Autowired
	public void setMapaService(TrabajadorService sut) {
		this.sut = sut;
	}
	
	@Autowired
	public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
		this.trabajadorRepository = trabajadorRepository;
	}


    public void setSut(TrabajadorService sut) {
        this.sut = sut;
    }

    @Before
    public void setUp() throws Exception {
        limpiarTrabajadors();
    }

    @Test
    public void testAniadirBase() {
        Long idTrabajador = sut.aniadirTrabajador("Sonda");

        assertNotNull(idTrabajador);
    }

    @Test
    public void testObtenerBase() {
        Long idTrabajador = sut.aniadirTrabajador("Sonda");

        Trabajador trabajador = sut.obtenerTrabajador(idTrabajador);

        assertNotNull(trabajador.getId());
        assertTrue(trabajador.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testObtenerBases() {
        List<Trabajador> trabajadores = sut.obtenerTrabajadors();
        trabajadores.forEach((trabajador) -> {
            assertNotNull(trabajador.getId());
        });
    }

    @Test
    public void testActualizarBase() {
        Long idTrabajador = sut.aniadirTrabajador("Sonda");

        Trabajador trabajador = sut.obtenerTrabajador(idTrabajador);
        trabajador.setTipoTrabajador("Sonda");

        Trabajador trabajadorMod = sut.obtenerTrabajador(idTrabajador);

        assertTrue(trabajadorMod.getTipoTrabajador().equalsIgnoreCase("Sonda"));
    }

    @Test
    public void testBorrarBase() {
        Long idTrabajador = sut.aniadirTrabajador("Sonda");

        sut.borrarTrabajador(idTrabajador);

        List<Trabajador> trabajadors = sut.obtenerTrabajadors();

        assertTrue(trabajadors.isEmpty());
    }

    private void limpiarTrabajadors() {
        List<Trabajador> bases = sut.obtenerTrabajadors();
        bases.forEach((base) -> {
            trabajadorRepository.delete(base);
        });
    }
}
