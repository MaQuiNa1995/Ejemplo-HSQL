package maquina1995.hibernate.repository;

import java.util.List;

import maquina1995.hibernate.dominio.Elementalista;
import maquina1995.hibernate.dominio.ElementalistaPk;

public interface ElementalistaRepository {

	Elementalista create(Elementalista elementalista);

	Elementalista findByPk(ElementalistaPk elementalistaPk);

	List<Elementalista> findAll();

	Elementalista update(Elementalista elementalista);

	void delete(Elementalista elementalista);

}