package es.cic.curso.curso18.mascotastarcraft.repository;

import java.io.Serializable;

public interface Identificable<K> extends Serializable {

	K getId();

	void setId(K id);

}