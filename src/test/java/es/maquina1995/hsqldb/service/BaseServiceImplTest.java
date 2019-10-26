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
import es.maquina1995.hsqldb.dominio.Base;

/**
 * Clase de test para el testo de {@link BaseService}
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
public class BaseServiceImplTest {

    private BaseService cut;

    // ----------------- Create ------------------

    @Test
    @Transactional
    public void testAniadirBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Assertions.assertNotNull(idBase);
    }

    // ----------------- Read ------------------

    @Test
    @Transactional
    public void testObtenerBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Base base = cut.obtenerBase(idBase);

	Assertions.assertNotNull(base.getId());
	Assertions.assertTrue(base.getTipoMineral().equalsIgnoreCase("VespenoObtener"));
	Assertions.assertTrue(base.getCantidadMineral() == 10);
	Assertions.assertTrue(base.getTrabajadoresMaximo() == 5);
    }

    @Test
    @Transactional
    public void testObtenerBases() {
	cut.aniadirBase(10, "Vespeno", 5, 1);
	cut.aniadirBase(10, "Vespeno2", 5, 1);

	List<Base> listaBases = cut.obtenerBases();

	Assertions.assertFalse(listaBases.isEmpty());
	Assertions.assertEquals(2, listaBases.size());
	listaBases.forEach((base) -> Assertions.assertNotNull(base.getId()));
    }

    // ----------------- Update ------------------

    @Test
    @Transactional
    public void testActualizarBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Base base = cut.obtenerBase(idBase);
	base.setTipoMineral("Cristal");

	Base baseMod = cut.actualizarBase(base);

	Assertions.assertTrue(baseMod.getTipoMineral().equalsIgnoreCase("Cristal"));
    }

    // ----------------- Delete ------------------

    @Test
    @Transactional
    public void testBorrarBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	List<Base> listaBasesBd = cut.obtenerBases();

	Assertions.assertFalse(listaBasesBd.isEmpty());
	Assertions.assertEquals(2, listaBasesBd.size());

	cut.borrarBase(idBase);
	Assertions.assertTrue(cut.obtenerBases().isEmpty());
    }

    @Autowired
    public void setBaseService(BaseService baseService) {
	this.cut = baseService;
    }
}
