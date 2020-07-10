package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Oficio;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class OficioRepositoryImpl extends CrudRepositoryImpl<Long, Oficio> implements OficioRepository {

	@Override
	public Class<Oficio> getClassDeT() {
		return Oficio.class;
	}
}