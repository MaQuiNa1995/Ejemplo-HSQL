package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Personaje;
import maquina.hibernate.repository.CustomGenericRepository;

public interface PersonajeRepository extends CustomGenericRepository<Long, Personaje> {

	@Override
	Class<Personaje> getClassDeT();

}