package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.TecnicaKi;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class TecnicaKiRepositoryImpl extends JpaRepositoryImpl<Long, TecnicaKi> implements TecnicaKiRepository {

	@Override
	public Class<TecnicaKi> getClassDeT() {
		return TecnicaKi.class;
	}
}