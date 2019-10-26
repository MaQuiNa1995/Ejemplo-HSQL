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

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Base;
import es.maquina1995.hsqldb.repository.BaseRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class BaseServiceImplTest {

    private BaseService cut;
    private BaseRepository baseRepository;

    // ----------------- Create ------------------

    @Test
    public void testAniadirBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Assertions.assertNotNull(idBase);
    }

    // ----------------- Read ------------------

    @Test
    public void testObtenerBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Base base = cut.obtenerBase(idBase);

	Assertions.assertNotNull(base.getId());
	Assertions.assertTrue(base.getTipoMineral().equalsIgnoreCase("Vespeno"));
	Assertions.assertTrue(base.getCantidadMineral() == 10);
	Assertions.assertTrue(base.getTrabajadoresMaximo() == 5);
    }

    @Test
    public void testObtenerBases() {
	List<Base> listaBases = cut.obtenerBases();

	Assertions.assertFalse(listaBases.isEmpty());
	listaBases.forEach((base) -> Assertions.assertNotNull(base.getId()));
    }

    // ----------------- Update ------------------

    @Test
    public void testActualizarBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	Base base = cut.obtenerBase(idBase);
	base.setTipoMineral("Cristal");

	Base baseMod = cut.actualizarBase(base);

	Assertions.assertTrue(baseMod.getTipoMineral().equalsIgnoreCase("Cristal"));
    }

    // ----------------- Delete ------------------

    @Test
    public void testBorrarBase() {
	Long idBase = cut.aniadirBase(10, "Vespeno", 5, 1);

	cut.borrarBase(idBase);

	List<Base> bases = cut.obtenerBases();

	Assertions.assertTrue(bases.isEmpty());
    }

    @Autowired
    public void setBaseRepository(BaseRepository baseRepository) {
	this.baseRepository = baseRepository;
    }

    @Autowired
    public void setBaseService(BaseService baseService) {
	this.cut = baseService;
    }
}
