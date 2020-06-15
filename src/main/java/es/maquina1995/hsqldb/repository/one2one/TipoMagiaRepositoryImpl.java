package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.TipoMagia;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class TipoMagiaRepositoryImpl extends CrudRepositoryImpl<Long, TipoMagia> implements TipoMagiaRepository {

	@Override
	public Class<TipoMagia> getClassDeT() {
		return TipoMagia.class;
	}

}