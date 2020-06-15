package es.maquina1995.hsqldb.repository.one2one;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.one2one.Mago;
import es.maquina1995.hsqldb.repository.CrudRepositoryImpl;

@Repository
public class MagoRepositoryImpl extends CrudRepositoryImpl<Long, Mago> implements MagoRepository {

	@Override
	public Class<Mago> getClassDeT() {
		return Mago.class;
	}
}