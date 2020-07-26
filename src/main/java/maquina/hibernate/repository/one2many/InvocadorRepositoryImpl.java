package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.Invocador;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class InvocadorRepositoryImpl extends JpaRepositoryImpl<Long, Invocador> implements InvocadorRepository {

	@Override
	public Class<Invocador> getClassDeT() {
		return Invocador.class;
	}
}