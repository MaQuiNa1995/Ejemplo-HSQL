package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.InvocacionSuprema;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class InvocacionSupremaRepositoryImpl extends JpaRepositoryImpl<Long, InvocacionSuprema>
		implements InvocacionSupremaRepository {

	@Override
	public Class<InvocacionSuprema> getClassDeT() {
		return InvocacionSuprema.class;
	}
}