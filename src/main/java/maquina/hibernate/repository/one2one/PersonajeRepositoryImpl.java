package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Personaje;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class PersonajeRepositoryImpl extends JpaRepositoryImpl<Long, Personaje> implements PersonajeRepository {

	@Override
	public Class<Personaje> getClassDeT() {
		return Personaje.class;
	}
}