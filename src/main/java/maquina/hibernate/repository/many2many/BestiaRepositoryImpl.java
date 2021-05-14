package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Bestia;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class BestiaRepositoryImpl extends CustomGenericRepositoryImpl<Long, Bestia> implements BestiaRepository {

	@Override
	public Class<Bestia> getClassDeT() {
		return Bestia.class;
	}
}