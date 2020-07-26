package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.repository.JpaRepository;

public interface NinjutsuRepository extends JpaRepository<Long, Ninjutsu> {

	@Override
	Class<Ninjutsu> getClassDeT();

}