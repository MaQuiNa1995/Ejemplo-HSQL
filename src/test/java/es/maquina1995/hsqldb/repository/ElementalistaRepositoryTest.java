package es.maquina1995.hsqldb.repository;

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
import es.maquina1995.hsqldb.dominio.Elementalista;
import es.maquina1995.hsqldb.dominio.ElementalistaPk;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class ElementalistaRepositoryTest {

	private Elementalista elementalista;

	@Autowired
	private ElementalistaRepository cut;

	@BeforeEach
	public void setUp() {
		this.elementalista = new Elementalista();
		this.elementalista.setNombre("Natsu");

		ElementalistaPk id = new ElementalistaPk();
		id.setElemento("Fuego");
		id.setPoder(100L);

		this.elementalista.setId(id);

	}

	@Test
	public void createTest() {

		cut.create(elementalista);

		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);
	}

	@Test
	public void readByPkTest() {
		Assertions.assertNull(cut.findByPk(this.elementalista.getId()));
		cut.create(elementalista);
		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);

	}

	@Test
	public void findAllTest() {
		cut.create(elementalista);

		Assertions.assertEquals(1, cut.findAll().size());
	}

	@Test
	public void updateTest() {

		cut.create(elementalista);

		ElementalistaPk idAnterior = elementalista.getId();

		ElementalistaPk id = new ElementalistaPk();
		id.setElemento("Agua");
		id.setPoder(50L);

		elementalista.setId(id);

		cut.update(elementalista);

		Assertions.assertNotEquals(elementalista.getId(), idAnterior);

	}

	@Test
	public void deleteTest() {

		cut.create(elementalista);

		Assertions.assertEquals(1, cut.findAll().size());

		cut.delete(cut.update(elementalista));

		Assertions.assertTrue(cut.findAll().isEmpty());

	}

}
