package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.TipoMagia;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class TipoMagiaRepositoryImpl extends JpaRepositoryImpl<Long, TipoMagia> implements TipoMagiaRepository {

	@Override
	public Class<TipoMagia> getClassDeT() {
		return TipoMagia.class;
	}

}