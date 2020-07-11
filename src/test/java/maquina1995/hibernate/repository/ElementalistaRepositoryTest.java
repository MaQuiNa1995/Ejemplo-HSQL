package maquina1995.hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

import maquina1995.hibernate.configuration.HibernateConfig;
import maquina1995.hibernate.dominio.Elementalista;
import maquina1995.hibernate.dominio.ElementalistaPk;
import maquina1995.hibernate.repository.ElementalistaRepository;

/**
 * Para que haga rollback automático en los test el método debe ir con el
 * {@link Transactional}
 * 
 * @author MaQuiNa1995
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { HibernateConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class ElementalistaRepositoryTest {

	@PersistenceContext
	private EntityManager entityManager;

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
	@Transactional
	public void createTest() {

		cut.create(elementalista);

		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);
	}

	@Test
	@Transactional
	public void readByPkTest() {
		Assertions.assertNull(cut.findByPk(this.elementalista.getId()));

		entityManager.persist(elementalista);

		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);

	}

	@Test
	@Transactional
	public void findAllTest() {
		entityManager.persist(elementalista);

		Assertions.assertEquals(1, cut.findAll().size());
	}

	@Test
	@Transactional
	public void updateTest() {
		entityManager.persist(elementalista);

		ElementalistaPk idAnterior = elementalista.getId();

		ElementalistaPk id = new ElementalistaPk();
		id.setElemento("Agua");
		id.setPoder(50L);

		elementalista.setId(id);

		cut.update(elementalista);

		Assertions.assertNotEquals(elementalista.getId(), idAnterior);

	}

	@Test
	@Transactional
	public void deleteTest() {

		entityManager.persist(elementalista);

		Assertions.assertEquals(1, cut.findAll().size());

		cut.delete(elementalista);

		Assertions.assertTrue(cut.findAll().isEmpty());

	}

}
