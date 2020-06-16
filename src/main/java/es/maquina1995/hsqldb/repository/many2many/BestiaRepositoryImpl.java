package es.maquina1995.hsqldb.repository.many2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.many2many.Bestia;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class BestiaRepositoryImpl extends CrudRepositoryImpl<Long, Bestia> implements BestiaRepository {

	@Override
	public Class<Bestia> getClassDeT() {
		return Bestia.class;
	}
}