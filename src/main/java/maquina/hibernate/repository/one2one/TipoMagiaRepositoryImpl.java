package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.TipoMagia;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class TipoMagiaRepositoryImpl extends CustomGenericRepositoryImpl<Long, TipoMagia> implements TipoMagiaRepository {

	@Override
	public Class<TipoMagia> getClassDeT() {
		return TipoMagia.class;
	}

}