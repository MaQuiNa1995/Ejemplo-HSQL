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

@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public abstract class AbstractRepositoryImplTest<K extends Number, T extends Identificable<K>> {

    @PersistenceContext
    private EntityManager entityManager;

    public abstract CrudRepository<K, T> getRepository();

    public abstract T getInstanceDeTParaNuevo();

    public abstract T getInstanceDeTParaLectura();

    public abstract boolean sonDatosIguales(T objeto1, T objeto2);

    public abstract K getClavePrimariaNoExistente();

    public abstract T getInstanceDeTParaModificar(K id);

    @Test
    public void testAdd() {
	T instancia = getInstanceDeTParaNuevo();
	Assertions.assertNull(instancia.getId());

	instancia = getRepository().persist(instancia);

	Assertions.assertNotNull(instancia.getId());
    }

    @Test
    public void testRead() {
	K clavePrimaria = generaDatoLectura();

	T resultado = getRepository().readByPk(clavePrimaria);

	Assertions.assertTrue(sonDatosIguales(getInstanceDeTParaLectura(), resultado));
    }

    @Test
    public void testRead_NoExiste() {
	K clavePrimaria = getClavePrimariaNoExistente();

	Assertions.assertThrows(PersistenceException.class, () -> {
	    getRepository().readByPk(clavePrimaria);
	});

    }

    @Test
    public void testList() {
	
	for (int i = 0; i < 3; i++) {
	    generaDatoLectura();
	}

	List<T> resultado = getRepository().findAll();

	Assertions.assertTrue(resultado.size() >= 3);
    }

    @Test
    public void testUpdate() {
	K id = generaDatoLectura();

	T objetoUpdate = getInstanceDeTParaModificar(id);

	getRepository().merge(objetoUpdate);

	T enBBDD = entityManager.find(getRepository().getClassDeT(), id);

	Assertions.assertTrue(sonDatosIguales(getInstanceDeTParaModificar(id), enBBDD));
    }

    @Test
    public void testDelete() {
	K clavePrimaria = generaDatoLectura();

	getRepository().deleteByPk(clavePrimaria);

	Identificable<?> objetoBd = entityManager.find(getRepository().getClassDeT(), clavePrimaria);

	Assertions.assertNull(objetoBd);
    }

    private K generaDatoLectura() {
	T instancia = getInstanceDeTParaLectura();

	entityManager.persist(instancia);

	return instancia.getId();
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

}
