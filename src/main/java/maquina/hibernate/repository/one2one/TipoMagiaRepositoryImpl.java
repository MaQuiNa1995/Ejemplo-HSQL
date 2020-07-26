package maquina.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2one.TipoMagia;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class TipoMagiaRepositoryImpl extends JpaRepositoryImpl<Long, TipoMagia> implements TipoMagiaRepository {

	@Override
	public Class<TipoMagia> getClassDeT() {
		return TipoMagia.class;
	}

}