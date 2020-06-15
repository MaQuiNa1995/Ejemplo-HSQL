package es.maquina1995.hsqldb.repository.one2one;

import es.maquina1995.hsqldb.dominio.one2one.Oficio;
import es.maquina1995.hsqldb.repository.CrudRepository;

public interface OficioRepository extends CrudRepository<Long, Oficio> {

	@Override
	Class<Oficio> getClassDeT();

}