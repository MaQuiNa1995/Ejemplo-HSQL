package es.maquina1995.hsqldb.repository.many2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.many2many.Calidad;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class CalidadRepositoryImpl extends CrudRepositoryImpl<Long, Calidad> implements CalidadRepository {

	@Override
	public Class<Calidad> getClassDeT() {
		return Calidad.class;
	}
}