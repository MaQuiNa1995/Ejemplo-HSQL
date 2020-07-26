package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.Ninja;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class NinjaRepositoryImpl extends JpaRepositoryImpl<Long, Ninja> implements NinjaRepository {

	@Override
	public Class<Ninja> getClassDeT() {
		return Ninja.class;
	}
}