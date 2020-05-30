package es.maquina1995.hsqldb.repository;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Elementalista;
import es.maquina1995.hsqldb.dominio.ElementalistaPk;

public interface ElementalistaRepository {

	Elementalista create(Elementalista elementalista);

	Elementalista findByPk(ElementalistaPk elementalistaPk);

	List<Elementalista> findAll();

	Elementalista update(Elementalista elementalista);

	void delete(Elementalista elementalista);

}