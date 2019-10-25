package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class CrudRepositoryImpl<K extends Number, T extends Identificable<K>> implements CrudRepository<K, T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public T persist(T nuevo) {
	entityManager.persist(nuevo);
	entityManager.flush();
	return nuevo;
    }

    @Override
    @Transactional
    public T readByPk(K id) {
	return entityManager.find(getClassDeT(), id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> findAll() {
	return entityManager.createNativeQuery("SELECT * FROM " + getNombreTabla(), getClassDeT()).getResultList();
    }

    @Override
    @Transactional
    public void deleteByPk(K id) {
	T aBorrar = entityManager.find(getClassDeT(), id);
	delete(aBorrar);
    }

    @Override
    @Transactional
    public void delete(T aBorrar) {
	entityManager.remove(aBorrar);
	entityManager.flush();
    }

    @Override
    @Transactional
    public T merge(T modificado) {
	T modificadoBd = entityManager.merge(modificado);
	entityManager.flush();
	return modificadoBd;
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }
}
