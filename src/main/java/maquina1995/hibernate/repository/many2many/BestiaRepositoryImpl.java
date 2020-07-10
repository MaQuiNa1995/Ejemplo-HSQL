package maquina1995.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.many2many.Bestia;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class BestiaRepositoryImpl extends CrudRepositoryImpl<Long, Bestia> implements BestiaRepository {

	@Override
	public Class<Bestia> getClassDeT() {
		return Bestia.class;
	}
}