package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericCrudRepositoryImpl<K extends Number, T extends Identificable<K>>
	implements CrudRepository<K, T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public T persist(T nuevo) {
	entityManager.persist(nuevo);
	entityManager.flush();
	return nuevo;
    }

    @Override
    public T readByPk(K id) {
	return entityManager.find(getClassDeT(), id);
    }

    @Override
    public List<T> findAll() {
	return entityManager.createNativeQuery("select * from " + getNombreTabla(), getClassDeT()).getResultList();
    }

    @Override
    public void deleteByPk(K id) {
	T aBorrar = entityManager.find(getClassDeT(), id);
	delete(aBorrar);
    }

    @Override
    public void delete(T aBorrar) {
	entityManager.remove(aBorrar);
    }

    @Override
    public T merge(T modificado) {
	return entityManager.merge(modificado);
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }
}
