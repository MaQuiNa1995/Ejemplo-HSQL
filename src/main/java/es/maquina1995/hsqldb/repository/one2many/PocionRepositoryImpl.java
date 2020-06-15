package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.Pocion;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class PocionRepositoryImpl extends CrudRepositoryImpl<Long, Pocion> implements PocionRepository {

	@Override
	public Class<Pocion> getClassDeT() {
		return Pocion.class;
	}
}