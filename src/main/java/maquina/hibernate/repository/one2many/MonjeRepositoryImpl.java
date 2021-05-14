package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.Monje;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class MonjeRepositoryImpl extends CustomGenericRepositoryImpl<Long, Monje> implements MonjeRepository {

	@Override
	public Class<Monje> getClassDeT() {
		return Monje.class;
	}
}