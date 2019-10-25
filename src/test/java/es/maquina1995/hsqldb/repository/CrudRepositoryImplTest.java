package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

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
 *        {@link Entity}
 */
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public abstract class CrudRepositoryImplTest<K extends Number, T extends Identificable<K>> {

    @PersistenceContext
    private EntityManager entityManager;

    public abstract CrudRepository<K, T> getRepository();

    public abstract T getInstanceDeTParaNuevo();

    public abstract T getInstanceDeTParaLectura();

    public abstract boolean sonDatosIguales(T objeto1, T objeto2);

    public abstract K getClavePrimariaNoExistente();

    public abstract T getInstanceDeTParaModificar(K id);

    @Test
    @Transactional
    public void testAdd() {
	T instancia = getInstanceDeTParaNuevo();
	Assertions.assertNull(instancia.getId());

	instancia = getRepository().persist(instancia);

	Assertions.assertNotNull(instancia.getId());
    }

    @Test
    @Transactional
    public void testRead() {
	K clavePrimaria = generaDatoLectura();

	T resultado = getRepository().readByPk(clavePrimaria);

	Assertions.assertTrue(sonDatosIguales(getInstanceDeTParaLectura(), resultado));
    }

    @Test
    @Transactional
    public void testReadNoExiste() {
	K clavePrimaria = getClavePrimariaNoExistente();

	Assertions.assertThrows(PersistenceException.class, () -> getRepository().readByPk(clavePrimaria));

    }

    @Test
    @Transactional
    public void testFindAll() {

	for (int i = 0; i < 3; i++) {
	    generaDatoLectura();
	}

	List<T> resultado = getRepository().findAll();

	Assertions.assertTrue(resultado.size() >= 3);
    }

    @Test
    @Transactional
    public void testUpdate() {
	K clavePrimaria = generaDatoLectura();

	T objetoUpdate = getInstanceDeTParaModificar(clavePrimaria);

	getRepository().merge(objetoUpdate);

	T enBBDD = entityManager.find(getRepository().getClassDeT(), clavePrimaria);

	Assertions.assertTrue(sonDatosIguales(getInstanceDeTParaModificar(clavePrimaria), enBBDD));
    }

    @Test
    @Transactional
    public void testDelete() {
	K clavePrimaria = generaDatoLectura();

	getRepository().deleteByPk(clavePrimaria);

	Identificable<?> objetoBd = entityManager.find(getRepository().getClassDeT(), clavePrimaria);

	Assertions.assertNull(objetoBd);
    }

    @Transactional
    private K generaDatoLectura() {
	T instancia = getInstanceDeTParaLectura();
	entityManager.persist(instancia);
	return instancia.getId();
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

}
