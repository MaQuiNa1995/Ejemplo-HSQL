package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Arma;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class ArmaRepositoryImpl extends JpaRepositoryImpl<Long, Arma> implements ArmaRepository {

	@Override
	public Class<Arma> getClassDeT() {
		return Arma.class;
	}
}