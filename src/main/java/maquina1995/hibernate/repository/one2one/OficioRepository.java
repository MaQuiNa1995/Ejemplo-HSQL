package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Oficio;
import maquina1995.hibernate.repository.CrudRepository;

public interface OficioRepository extends CrudRepository<Long, Oficio> {

	@Override
	Class<Oficio> getClassDeT();

}