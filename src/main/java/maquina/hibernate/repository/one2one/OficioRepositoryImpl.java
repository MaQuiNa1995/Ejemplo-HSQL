package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Oficio;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class OficioRepositoryImpl extends CustomGenericRepositoryImpl<Long, Oficio> implements OficioRepository {

	@Override
	public Class<Oficio> getClassDeT() {
		return Oficio.class;
	}
}