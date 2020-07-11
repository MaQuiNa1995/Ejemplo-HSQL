package maquina1995.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.many2many.Calidad;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class CalidadRepositoryImpl extends JpaRepositoryImpl<Long, Calidad> implements CalidadRepository {

	@Override
	public Class<Calidad> getClassDeT() {
		return Calidad.class;
	}
}