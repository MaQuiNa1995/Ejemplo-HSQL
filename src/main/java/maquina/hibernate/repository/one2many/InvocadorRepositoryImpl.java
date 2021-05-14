package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.Invocador;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class InvocadorRepositoryImpl extends CustomGenericRepositoryImpl<Long, Invocador> implements InvocadorRepository {

	@Override
	public Class<Invocador> getClassDeT() {
		return Invocador.class;
	}
}