package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Personaje;
import maquina1995.hibernate.repository.CrudRepository;

public interface PersonajeRepository extends CrudRepository<Long, Personaje> {

	@Override
	Class<Personaje> getClassDeT();

}