package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.TecnicaKi;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class TecnicaKiRepositoryImpl extends CrudRepositoryImpl<Long, TecnicaKi> implements TecnicaKiRepository {

	@Override
	public Class<TecnicaKi> getClassDeT() {
		return TecnicaKi.class;
	}
}