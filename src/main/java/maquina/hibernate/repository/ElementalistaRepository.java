package maquina.hibernate.repository;

import java.util.List;

import maquina.hibernate.dominio.Elementalista;
import maquina.hibernate.dominio.ElementalistaPk;

public interface ElementalistaRepository {

	Elementalista create(Elementalista elementalista);

	Elementalista findByPk(ElementalistaPk elementalistaPk);

	List<Elementalista> findAll();

	Elementalista update(Elementalista elementalista);

	void delete(Elementalista elementalista);

}