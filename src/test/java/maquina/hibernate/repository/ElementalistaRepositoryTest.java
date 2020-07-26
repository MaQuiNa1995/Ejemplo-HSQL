package maquina.hibernate.repository;

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

import maquina.hibernate.configuration.HibernateConfig;
import maquina.hibernate.dominio.Elementalista;
import maquina.hibernate.dominio.ElementalistaPk;

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
class ElementalistaRepositoryTest {

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
	void createTest() {

		cut.create(elementalista);

		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);
	}

	@Test
	@Transactional
	void readByPkTest() {
		Assertions.assertNull(cut.findByPk(this.elementalista.getId()));

		entityManager.persist(this.elementalista);

		Assertions.assertEquals(cut.findByPk(this.elementalista.getId()), this.elementalista);

	}

	@Test
	@Transactional
	void findAllTest() {
		entityManager.persist(this.elementalista);

		Assertions.assertEquals(1, cut.findAll()
				.size());
	}

	@Test
	@Transactional
	void updateTest() {
		entityManager.persist(this.elementalista);

		ElementalistaPk idAnterior = this.elementalista.getId();

		ElementalistaPk id = new ElementalistaPk();
		id.setElemento("Agua");
		id.setPoder(50L);

		this.elementalista.setId(id);

		cut.update(this.elementalista);

		Assertions.assertNotEquals(this.elementalista.getId(), idAnterior);

	}

	@Test
	@Transactional
	void deleteTest() {

		entityManager.persist(this.elementalista);

		Assertions.assertEquals(1, cut.findAll()
				.size());

		cut.delete(this.elementalista);

		Assertions.assertTrue(cut.findAll()
				.isEmpty());

	}

}
