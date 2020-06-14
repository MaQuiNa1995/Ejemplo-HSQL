package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Rango;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class RangoRepositoryImpl extends CrudRepositoryImpl<Long, Rango> implements RangoRepository {

	public static final String TABLA = "RANGO";

	@Override
	public Class<Rango> getClassDeT() {
		return Rango.class;
	}
}