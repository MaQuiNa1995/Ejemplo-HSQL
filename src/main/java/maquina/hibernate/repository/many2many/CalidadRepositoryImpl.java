package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Calidad;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class CalidadRepositoryImpl extends JpaRepositoryImpl<Long, Calidad> implements CalidadRepository {

	@Override
	public Class<Calidad> getClassDeT() {
		return Calidad.class;
	}
}