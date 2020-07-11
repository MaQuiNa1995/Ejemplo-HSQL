package maquina1995.hibernate.repository.one2one;

import maquina1995.hibernate.dominio.one2one.Ninjutsu;
import maquina1995.hibernate.repository.JpaRepository;

public interface NinjutsuRepository extends JpaRepository<Long, Ninjutsu> {

	@Override
	Class<Ninjutsu> getClassDeT();

}