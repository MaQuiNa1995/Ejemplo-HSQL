package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Ninjutsu;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class NinjutsuRepositoryImpl extends JpaRepositoryImpl<Long, Ninjutsu> implements NinjutsuRepository {

	@Override
	public Class<Ninjutsu> getClassDeT() {
		return Ninjutsu.class;
	}

}