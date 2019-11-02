package es.maquina1995.hsqldb.repository;

import java.io.Serializable;

public interface Persistible<K> extends Serializable {

    K getId();

    void setId(K id);

}