package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Personaje;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class PersonajeRepositoryImpl extends JpaRepositoryImpl<Long, Personaje> implements PersonajeRepository {

	@Override
	public Class<Personaje> getClassDeT() {
		return Personaje.class;
	}
}