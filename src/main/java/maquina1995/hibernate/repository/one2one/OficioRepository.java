package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Oficio;
import maquina1995.hibernate.repository.JpaRepository;

public interface OficioRepository extends JpaRepository<Long, Oficio> {

	@Override
	Class<Oficio> getClassDeT();

}