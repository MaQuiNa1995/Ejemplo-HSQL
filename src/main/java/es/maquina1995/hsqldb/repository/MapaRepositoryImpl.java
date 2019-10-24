package es.maquina1995.hsqldb.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Mapa;

@Repository
@Transactional
public class MapaRepositoryImpl extends GenericCrudRepositoryImpl<Long, Mapa> implements MapaRepository {

	@Override
	public Class<Mapa> getClassDeT() {
		return Mapa.class;
	}

	@Override
	public String getNombreTabla() {
		return "Mapa";
	}
}
