package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.InvocacionSuprema;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class InvocacionSupremaRepositoryImpl extends CustomGenericRepositoryImpl<Long, InvocacionSuprema>
		implements InvocacionSupremaRepository {

	@Override
	public Class<InvocacionSuprema> getClassDeT() {
		return InvocacionSuprema.class;
	}
}