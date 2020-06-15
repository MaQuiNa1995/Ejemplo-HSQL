package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.InvocacionSuprema;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class InvocacionSupremaRepositoryImpl extends CrudRepositoryImpl<Long, InvocacionSuprema>
		implements InvocacionSupremaRepository {

	@Override
	public Class<InvocacionSuprema> getClassDeT() {
		return InvocacionSuprema.class;
	}
}