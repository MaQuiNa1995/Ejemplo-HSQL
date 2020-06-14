package es.maquina1995.hsqldb.repository;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Persistible;

public interface CrudRepository<K extends Number, T extends Persistible<K>> {

	T persist(T nuevo);

	T readByPk(K id);

	List<T> findAll();

	T merge(T modificado);

	void deleteByPk(K id);

	void delete(T aBorrar);

	public abstract Class<T> getClassDeT();
}