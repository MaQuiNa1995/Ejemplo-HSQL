package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Oficio;
import maquina.hibernate.repository.CustomGenericRepository;

public interface OficioRepository extends CustomGenericRepository<Long, Oficio> {

	@Override
	Class<Oficio> getClassDeT();

}