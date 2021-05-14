package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Rango;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class RangoRepositoryImpl extends CustomGenericRepositoryImpl<Long, Rango> implements RangoRepository {

	@Override
	public Class<Rango> getClassDeT() {
		return Rango.class;
	}
}