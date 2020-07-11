package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Ninja;
import maquina1995.hibernate.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Long, Ninja> {

	@Override
	Class<Ninja> getClassDeT();

}