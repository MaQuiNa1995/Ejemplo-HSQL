package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Ninjutsu;
import maquina1995.hibernate.repository.CrudRepository;

public interface NinjutsuRepository extends CrudRepository<Long, Ninjutsu> {

	@Override
	Class<Ninjutsu> getClassDeT();

}