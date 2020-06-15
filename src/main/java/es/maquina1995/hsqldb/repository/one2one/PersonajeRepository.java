package es.maquina1995.hsqldb.repository.one2one;

import es.maquina1995.hsqldb.dominio.one2one.Personaje;
import es.maquina1995.hsqldb.repository.CrudRepository;

public interface PersonajeRepository extends CrudRepository<Long, Personaje> {

	@Override
	Class<Personaje> getClassDeT();

}