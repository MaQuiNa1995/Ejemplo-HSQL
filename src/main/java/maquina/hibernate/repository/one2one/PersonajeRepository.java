package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Personaje;
import maquina.hibernate.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Long, Personaje> {

	@Override
	Class<Personaje> getClassDeT();

}