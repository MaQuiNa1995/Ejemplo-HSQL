package maquina1995.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.many2many.Bestia;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class BestiaRepositoryImpl extends JpaRepositoryImpl<Long, Bestia> implements BestiaRepository {

	@Override
	public Class<Bestia> getClassDeT() {
		return Bestia.class;
	}
}