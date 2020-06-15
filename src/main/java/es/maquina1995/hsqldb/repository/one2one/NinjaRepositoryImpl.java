package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Ninja;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class NinjaRepositoryImpl extends CrudRepositoryImpl<Long, Ninja> implements NinjaRepository {

	@Override
	public Class<Ninja> getClassDeT() {
		return Ninja.class;
	}
}