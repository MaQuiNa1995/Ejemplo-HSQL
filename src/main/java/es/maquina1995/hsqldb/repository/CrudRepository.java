package es.maquina1995.hsqldb.repository;

import java.util.List;

public interface CrudRepository<K extends Number, T extends Identificable<K>> {

    T persist(T nuevo);

    T readByPk(K id);

    List<T> findAll();

    T merge(T modificado);

    void deleteByPk(K id);

    void delete(T aBorrar);

    public abstract Class<T> getClassDeT();

    public abstract String getNombreTabla();
}