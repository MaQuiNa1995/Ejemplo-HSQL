package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.Pocion;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class PocionRepositoryImpl extends JpaRepositoryImpl<Long, Pocion> implements PocionRepository {

	@Override
	public Class<Pocion> getClassDeT() {
		return Pocion.class;
	}
}