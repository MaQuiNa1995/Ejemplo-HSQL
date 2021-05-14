package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Arma;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class ArmaRepositoryImpl extends CustomGenericRepositoryImpl<Long, Arma> implements ArmaRepository {

	@Override
	public Class<Arma> getClassDeT() {
		return Arma.class;
	}
}