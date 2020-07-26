package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Oficio;
import maquina.hibernate.repository.JpaRepository;

public interface OficioRepository extends JpaRepository<Long, Oficio> {

	@Override
	Class<Oficio> getClassDeT();

}