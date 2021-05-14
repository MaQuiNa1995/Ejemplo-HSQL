package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Personaje;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class PersonajeRepositoryImpl extends CustomGenericRepositoryImpl<Long, Personaje> implements PersonajeRepository {

	@Override
	public Class<Personaje> getClassDeT() {
		return Personaje.class;
	}
}