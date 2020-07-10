package maquina1995.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.many2many.Calidad;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class CalidadRepositoryImpl extends CrudRepositoryImpl<Long, Calidad> implements CalidadRepository {

	@Override
	public Class<Calidad> getClassDeT() {
		return Calidad.class;
	}
}