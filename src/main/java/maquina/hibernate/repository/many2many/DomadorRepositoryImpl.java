package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Domador;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class DomadorRepositoryImpl extends CustomGenericRepositoryImpl<Long, Domador> implements DomadorRepository {

	@Override
	public Class<Domador> getClassDeT() {
		return Domador.class;
	}
}