package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.dominio.AbstractEntidadSimple;
import es.maquina1995.hsqldb.repository.constants.ConstantesTesting;

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
 * 
 * @author MaQuiNa1995
 *
 * @param <K> Genérico que representa un objeto que sea hijo de {@link Number}
 * @param <T> Genérico que representa un objeto que esté anotado con
 *            {@link Entity}
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public abstract class CrudRepositoryImplTest<K, T extends AbstractEntidadSimple<K>> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected abstract CrudRepository<K, T> getRepository();

	protected abstract T getInstanceDeT();

	protected abstract boolean sonDatosIguales(T objeto1, T objeto2);

	protected abstract K getClavePrimariaNoExistente();

	protected T getInstanceDeTParaModificar(K id) {
		T objetoModificar = getInstanceDeT();
		objetoModificar.setId(id);
		objetoModificar.setNombre(ConstantesTesting.CADENA_TEXTO);

		return objetoModificar;

	}

	@Test
	@Transactional
	public void addTest() {
		T instancia = getInstanceDeT();
		Assertions.assertNull(instancia.getId());
		instancia = getRepository().persist(instancia);
		Assertions.assertNotNull(instancia.getId());
	}

	@Test
	@Transactional(readOnly = true)
	public void readTest() {
		K clavePrimaria = generaDatoLectura();

		T resultado = getRepository().readByPk(clavePrimaria);

		Assertions.assertNotNull(resultado);
		Assertions.assertTrue(sonDatosIguales(getInstanceDeT(), resultado));
	}

	@Test
	@Transactional(readOnly = true)
	public void readNoExisteTest() {
		K clavePrimaria = getClavePrimariaNoExistente();

		Assertions.assertNull(getRepository().readByPk(clavePrimaria));

	}

	@Test
	@Transactional
	public void findAllTest() {

		Assertions.assertTrue(getRepository().findAll().isEmpty());

		for (int i = 0; i < 3; i++) {
			this.generaDatoLectura();
		}

		List<T> resultado = getRepository().findAll();

		Assertions.assertEquals(3, resultado.size());
	}

	@Test
	@Transactional
	public void updateTest() {
		K clavePrimaria = generaDatoLectura();

		T objetoUpdate = getInstanceDeTParaModificar(clavePrimaria);

		getRepository().merge(objetoUpdate);

		T enBBDD = entityManager.find(getRepository().getClassDeT(), clavePrimaria);

		Assertions.assertTrue(sonDatosIguales(getInstanceDeTParaModificar(clavePrimaria), enBBDD));
	}

	@Test
	@Transactional
	public void deleteTest() {
		K clavePrimaria = generaDatoLectura();

		Assertions.assertFalse(getRepository().findAll().isEmpty());

		getRepository().deleteByPk(clavePrimaria);

		AbstractEntidadSimple<K> objetoBd = entityManager.find(getRepository().getClassDeT(), clavePrimaria);

		Assertions.assertNull(objetoBd);
	}

	@Transactional
	private K generaDatoLectura() {
		T instancia = getInstanceDeT();
		entityManager.persist(instancia);
		return instancia.getId();
	}

}
