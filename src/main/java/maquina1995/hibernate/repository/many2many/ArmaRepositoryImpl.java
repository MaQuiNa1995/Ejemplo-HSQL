package maquina1995.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.many2many.Arma;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class ArmaRepositoryImpl extends JpaRepositoryImpl<Long, Arma> implements ArmaRepository {

	@Override
	public Class<Arma> getClassDeT() {
		return Arma.class;
	}
}