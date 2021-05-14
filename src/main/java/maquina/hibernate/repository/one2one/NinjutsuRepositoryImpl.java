package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class NinjutsuRepositoryImpl extends CustomGenericRepositoryImpl<Long, Ninjutsu> implements NinjutsuRepository {

	@Override
	public Class<Ninjutsu> getClassDeT() {
		return Ninjutsu.class;
	}

}