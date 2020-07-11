package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Rango;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class RangoRepositoryImpl extends JpaRepositoryImpl<Long, Rango> implements RangoRepository {

	@Override
	public Class<Rango> getClassDeT() {
		return Rango.class;
	}
}