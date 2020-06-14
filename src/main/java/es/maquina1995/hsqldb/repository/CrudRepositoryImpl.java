package es.maquina1995.hsqldb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Persistible;

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
	public List<T> findAll() {

		String query = String.format("Select entity FROM %s entity", getClassDeT().getName());

		return entityManager.createQuery(query, getClassDeT()).getResultList();
	}

	@Override
	@Transactional
	public void deleteByPk(K id) {
		T aBorrar = entityManager.getReference(getClassDeT(), id);
		this.delete(aBorrar);
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

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
