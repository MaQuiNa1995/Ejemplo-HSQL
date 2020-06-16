package es.maquina1995.hsqldb.repository.many2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.many2many.Domador;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class DomadorRepositoryImpl extends CrudRepositoryImpl<Long, Domador> implements DomadorRepository {

	@Override
	public Class<Domador> getClassDeT() {
		return Domador.class;
	}
}