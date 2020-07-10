package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Rango;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class RangoRepositoryImpl extends CrudRepositoryImpl<Long, Rango> implements RangoRepository {

	@Override
	public Class<Rango> getClassDeT() {
		return Rango.class;
	}
}