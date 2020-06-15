package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Oficio;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class OficioRepositoryImpl extends CrudRepositoryImpl<Long, Oficio> implements OficioRepository {

	@Override
	public Class<Oficio> getClassDeT() {
		return Oficio.class;
	}
}