package maquina.hibernate.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import maquina.hibernate.dominio.AbstractEntidadSimple;

public interface CustomGenericRepository<K extends Serializable, T extends AbstractEntidadSimple<K>> {

	T persist(T nuevo);

	T readByPk(K id);

	List<T> findAll();

	T merge(T modificado);

	void deleteByPk(K id);

	void delete(T aBorrar);

	public abstract Class<T> getClassDeT();

	T readByNaturalId(UUID id);
}