package es.maquina1995.hsqldb.repository.one2one;

import es.maquina1995.hsqldb.dominio.one2one.Ninja;
import es.maquina1995.hsqldb.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Long, Ninja> {

	@Override
	Class<Ninja> getClassDeT();

}