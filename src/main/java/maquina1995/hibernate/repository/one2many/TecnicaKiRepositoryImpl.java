package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.TecnicaKi;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class TecnicaKiRepositoryImpl extends CrudRepositoryImpl<Long, TecnicaKi> implements TecnicaKiRepository {

	@Override
	public Class<TecnicaKi> getClassDeT() {
		return TecnicaKi.class;
	}
}