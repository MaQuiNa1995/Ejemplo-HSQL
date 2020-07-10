package maquina1995.hibernate.repository;

import java.util.List;
import java.util.UUID;

import maquina1995.hibernate.dominio.AbstractEntidadSimple;

public interface CrudRepository<K, T extends AbstractEntidadSimple<K>> {

	T persist(T nuevo);

	T readByPk(K id);

	List<T> findAll();

	T merge(T modificado);

	void deleteByPk(K id);

	void delete(T aBorrar);

	public abstract Class<T> getClassDeT();

	T readByNaturalId(UUID id);
}