package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Ninja;
import maquina1995.hibernate.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Long, Ninja> {

	@Override
	Class<Ninja> getClassDeT();

}