package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.Pocion;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class PocionRepositoryImpl extends CrudRepositoryImpl<Long, Pocion> implements PocionRepository {

	@Override
	public Class<Pocion> getClassDeT() {
		return Pocion.class;
	}
}