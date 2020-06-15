package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.Invocador;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class InvocadorRepositoryImpl extends CrudRepositoryImpl<Long, Invocador> implements InvocadorRepository {

	@Override
	public Class<Invocador> getClassDeT() {
		return Invocador.class;
	}
}