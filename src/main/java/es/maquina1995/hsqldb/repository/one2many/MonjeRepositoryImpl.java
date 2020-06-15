package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.Monje;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class MonjeRepositoryImpl extends CrudRepositoryImpl<Long, Monje> implements MonjeRepository {

	@Override
	public Class<Monje> getClassDeT() {
		return Monje.class;
	}
}