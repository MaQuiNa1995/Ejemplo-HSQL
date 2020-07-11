package maquina1995.hibernate.repository.one2one;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2one.Tecnica;
import maquina1995.hibernate.repository.JpaRepositoryImpl;

@Repository
public class TecnicaRepositoryImpl extends JpaRepositoryImpl<Long, Tecnica> implements TecnicaRepository {

	@Override
	public Class<Tecnica> getClassDeT() {
		return Tecnica.class;
	}

}