package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Tecnica;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class TecnicaRepositoryImpl extends CrudRepositoryImpl<Long, Tecnica> implements TecnicaRepository {

	@Override
	public Class<Tecnica> getClassDeT() {
		return Tecnica.class;
	}

}