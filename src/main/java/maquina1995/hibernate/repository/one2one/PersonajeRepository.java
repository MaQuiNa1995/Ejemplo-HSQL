package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Personaje;
import maquina1995.hibernate.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Long, Personaje> {

	@Override
	Class<Personaje> getClassDeT();

}