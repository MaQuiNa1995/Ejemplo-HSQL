package maquina.hibernate.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import maquina.hibernate.configuration.HibernateConfig;
import maquina.hibernate.dominio.AbstractEntidadSimple;

/**
 * Clase de test genérica para hacer test al vuelo de método tipicos de un CRUD
 * <p>
 * Lecciones Aprendidas:
 * <p>
 * si no pones el {@link TransactionalTestExecutionListener} spring no puede
 * crear el transactionManager en test con este error me tiré 1 tarde entera
 * <p>
 * Me daba un error de:
 * <p>
 * javax.persistence.TransactionRequiredException: No EntityManager with actual
 * transaction available for current thread - cannot reliably process 'persist'
 * call
 * <p>
 * <a href=
 * "https://github.com/MaQuiNa1995/Ejemplo-HSQL/commit/2cb42961e4834f20a3b772cd64a3cee5547f6326">Este
 * es el commit</a> donde arreglé el error
 * <p>
 * Según una regla de sonar los test de Jnit 5 deben tener el modificador
 * <code>Package</code>
 * <p>
 * Mas info de la regla: JUnit5 test classes and methods should have default
 * package visibility (java:S5786)
 * 
 * @author MaQuiNa1995
 *
 * @param <K> Genérico que representa el Id de la entidad que tiene que
 *            obligatoriamente implementar {@link Serializable}
 * @param <T> Genérico que representa un objeto que esté anotado con
 *            {@link javax.persistence.Entity}
 */
@Rollback
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { HibernateConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
abstract class JpaRepositoryImplTest<K extends Serializable, T extends AbstractEntidadSimple<K>> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected abstract CustomGenericRepository<K, T> getRepository();

	protected abstract T getInstanceDeT();

	protected abstract boolean sonDatosIguales(T objeto1, T objeto2);

	protected abstract K getClavePrimariaNoExistente();

	protected T getInstanceDeTParaModificar(K id) {
		T objetoModificar = this.getInstanceDeT();
		objetoModificar.setId(id);
		objetoModificar.setNombre("MaKy1995");

		return objetoModificar;
	}

	@Test
	@Transactional
	void addTest() {
		T instancia = this.getInstanceDeT();
		Assertions.assertNull(instancia.getId());
		instancia = this.getRepository()
		        .persist(instancia);
		Assertions.assertNotNull(instancia.getId());
	}

	@Test
	@Transactional
	void readTest() {
		K clavePrimaria = this.generaDatoLectura();

		T resultado = this.getRepository()
		        .readByPk(clavePrimaria);

		Assertions.assertNotNull(resultado);
		Assertions.assertTrue(this.sonDatosIguales(this.getInstanceDeT(), resultado));
	}

	@Test
	@Transactional
	void readByNaturalIdTest() {
		UUID idNatural = this.generaDatoLecturaNaturalId();

		T resultado = this.getRepository()
		        .readByNaturalId(idNatural);

		Assertions.assertNotNull(resultado);
		Assertions.assertTrue(this.sonDatosIguales(this.getInstanceDeT(), resultado));
	}

	@Test
	@Transactional(readOnly = true)
	void readNoExisteTest() {
		K clavePrimaria = this.getClavePrimariaNoExistente();

		Assertions.assertNull(this.getRepository()
		        .readByPk(clavePrimaria));

	}

	@Test
	@Transactional
	void findAllTest() {

		Assertions.assertTrue(this.getRepository()
		        .findAll()
		        .isEmpty());

		for (int i = 0; i < 3; i++) {
			this.generaDatoLectura();
		}

		List<T> resultado = this.getRepository()
		        .findAll();

		Assertions.assertEquals(3, resultado.size());
	}

	@Test
	@Transactional
	void updateTest() {
		K clavePrimaria = this.generaDatoLectura();

		T objetoUpdate = this.getInstanceDeTParaModificar(clavePrimaria);

		this.getRepository()
		        .merge(objetoUpdate);

		T enBBDD = this.entityManager.find(getRepository().getClassDeT(), clavePrimaria);

		Assertions.assertTrue(this.sonDatosIguales(this.getInstanceDeTParaModificar(clavePrimaria), enBBDD));
	}

	@Test
	@Transactional
	void deleteTest() {
		K clavePrimaria = this.generaDatoLectura();

		Assertions.assertFalse(this.getRepository()
		        .findAll()
		        .isEmpty());

		this.getRepository()
		        .deleteByPk(clavePrimaria);

		AbstractEntidadSimple<K> objetoBd = this.entityManager.find(getRepository().getClassDeT(), clavePrimaria);

		Assertions.assertNull(objetoBd);
	}

	/**
	 * Se hace {@link EntityManager#flush()} para que cree los campos de
	 * {@link maquina.hibernate.dominio.AbstractAuditable}
	 * 
	 * @return
	 */
	@Transactional
	private K generaDatoLectura() {

		T instancia = getInstanceDeT();
		this.entityManager.persist(instancia);
		this.entityManager.flush();

		return instancia.getId();
	}

	/**
	 * Se hace {@link EntityManager#flush()} para que cree los campos de
	 * {@link maquina.hibernate.dominio.AbstractAuditable}
	 * 
	 * @return
	 */
	@Transactional
	private UUID generaDatoLecturaNaturalId() {
		T instancia = this.getInstanceDeT();
		entityManager.persist(instancia);
		entityManager.flush();
		return instancia.getReferencia();
	}

}
