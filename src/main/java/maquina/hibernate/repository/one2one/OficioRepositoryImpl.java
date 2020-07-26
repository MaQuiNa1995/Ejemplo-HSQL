package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Oficio;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class OficioRepositoryImpl extends JpaRepositoryImpl<Long, Oficio> implements OficioRepository {

	@Override
	public Class<Oficio> getClassDeT() {
		return Oficio.class;
	}
}