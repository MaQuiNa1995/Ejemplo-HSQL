package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.Monje;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class MonjeRepositoryImpl extends JpaRepositoryImpl<Long, Monje> implements MonjeRepository {

	@Override
	public Class<Monje> getClassDeT() {
		return Monje.class;
	}
}