package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Personaje;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class PersonajeRepositoryImpl extends CrudRepositoryImpl<Long, Personaje> implements PersonajeRepository {

	@Override
	public Class<Personaje> getClassDeT() {
		return Personaje.class;
	}
}