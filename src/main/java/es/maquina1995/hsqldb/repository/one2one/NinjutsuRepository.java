package es.maquina1995.hsqldb.repository.one2one;

import es.maquina1995.hsqldb.dominio.one2one.Ninjutsu;
import es.maquina1995.hsqldb.repository.CrudRepository;

public interface NinjutsuRepository extends CrudRepository<Long, Ninjutsu> {

	@Override
	Class<Ninjutsu> getClassDeT();

}