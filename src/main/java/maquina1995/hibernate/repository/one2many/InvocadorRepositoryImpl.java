package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.Invocador;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class InvocadorRepositoryImpl extends CrudRepositoryImpl<Long, Invocador> implements InvocadorRepository {

	@Override
	public Class<Invocador> getClassDeT() {
		return Invocador.class;
	}
}