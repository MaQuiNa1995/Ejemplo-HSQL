package es.maquina1995.hsqldb.repository;

import java.util.List;

import es.maquina1995.hsqldb.dominio.AbstractEntidadSimple;

public interface CrudRepository<K, T extends AbstractEntidadSimple<K>> {

	T persist(T nuevo);

	T readByPk(K id);

	List<T> findAll();

	T merge(T modificado);

	void deleteByPk(K id);

	void delete(T aBorrar);

	public abstract Class<T> getClassDeT();
}