package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Ninja;
import maquina.hibernate.repository.CustomGenericRepository;

public interface NinjaRepository extends CustomGenericRepository<Long, Ninja> {

	@Override
	Class<Ninja> getClassDeT();

}