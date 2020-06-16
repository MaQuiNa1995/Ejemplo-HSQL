package es.maquina1995.hsqldb.repository.many2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.many2many.Arma;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class ArmaRepositoryImpl extends CrudRepositoryImpl<Long, Arma> implements ArmaRepository {

	@Override
	public Class<Arma> getClassDeT() {
		return Arma.class;
	}
}