package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class NinjutsuRepositoryImpl extends JpaRepositoryImpl<Long, Ninjutsu> implements NinjutsuRepository {

	@Override
	public Class<Ninjutsu> getClassDeT() {
		return Ninjutsu.class;
	}

}