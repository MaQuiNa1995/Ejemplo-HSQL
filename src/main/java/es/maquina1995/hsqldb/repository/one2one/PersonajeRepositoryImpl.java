package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Personaje;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class PersonajeRepositoryImpl extends CrudRepositoryImpl<Long, Personaje> implements PersonajeRepository {

	@Override
	public Class<Personaje> getClassDeT() {
		return Personaje.class;
	}
}