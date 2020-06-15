package es.maquina1995.hsqldb.repository.one2many;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2many.Alquimista;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class AlquimistaRepositoryImpl extends CrudRepositoryImpl<Long, Alquimista> implements AlquimistaRepository {

	@Override
	public Class<Alquimista> getClassDeT() {
		return Alquimista.class;
	}
}