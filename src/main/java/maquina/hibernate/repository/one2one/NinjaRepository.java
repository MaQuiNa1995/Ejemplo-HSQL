package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Ninja;
import maquina.hibernate.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Long, Ninja> {

	@Override
	Class<Ninja> getClassDeT();

}