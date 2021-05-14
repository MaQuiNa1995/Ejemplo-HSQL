package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.repository.CustomGenericRepository;

public interface NinjutsuRepository extends CustomGenericRepository<Long, Ninjutsu> {

	@Override
	Class<Ninjutsu> getClassDeT();

}