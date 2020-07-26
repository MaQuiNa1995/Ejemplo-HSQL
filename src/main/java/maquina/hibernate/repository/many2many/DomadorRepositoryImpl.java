package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Domador;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class DomadorRepositoryImpl extends JpaRepositoryImpl<Long, Domador> implements DomadorRepository {

	@Override
	public Class<Domador> getClassDeT() {
		return Domador.class;
	}
}