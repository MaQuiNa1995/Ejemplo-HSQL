package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class CrudRepositoryImpl<K extends Number, T extends Persistible<K>> implements CrudRepository<K, T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public T persist(T nuevo) {
	entityManager.persist(nuevo);
	return nuevo;
    }

    @Override
    @Transactional(readOnly = true)
    public T readByPk(K id) {
	return entityManager.find(getClassDeT(), id);
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
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
    }

    @Override
    @Transactional
    public T merge(T modificado) {
	return entityManager.merge(modificado);
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }
}
