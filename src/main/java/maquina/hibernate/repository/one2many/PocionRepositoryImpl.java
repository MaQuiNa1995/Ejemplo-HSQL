package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.Pocion;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class PocionRepositoryImpl extends CustomGenericRepositoryImpl<Long, Pocion> implements PocionRepository {

	@Override
	public Class<Pocion> getClassDeT() {
		return Pocion.class;
	}
}