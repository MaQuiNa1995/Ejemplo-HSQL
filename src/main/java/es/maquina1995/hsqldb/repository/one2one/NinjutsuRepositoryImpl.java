package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Ninjutsu;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class NinjutsuRepositoryImpl extends CrudRepositoryImpl<Long, Ninjutsu> implements NinjutsuRepository {

	public static final String TABLA = "NINJUTSU";

	@Override
	public Class<Ninjutsu> getClassDeT() {
		return Ninjutsu.class;
	}

}