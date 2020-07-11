package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Mago;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class MagoRepositoryImpl extends JpaRepositoryImpl<Long, Mago> implements MagoRepository {

	@Override
	public Class<Mago> getClassDeT() {
		return Mago.class;
	}
}