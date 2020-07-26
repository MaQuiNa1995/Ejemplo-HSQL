package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Bestia;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class BestiaRepositoryImpl extends JpaRepositoryImpl<Long, Bestia> implements BestiaRepository {

	@Override
	public Class<Bestia> getClassDeT() {
		return Bestia.class;
	}
}