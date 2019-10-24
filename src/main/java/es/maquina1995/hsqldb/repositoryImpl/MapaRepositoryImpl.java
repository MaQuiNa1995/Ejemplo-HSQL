package es.maquina1995.hsqldb.repositoryImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Mapa;
import es.maquina1995.hsqldb.repository.MapaRepository;

@Repository
@Transactional
public class MapaRepositoryImpl extends AbstractRepositoryImpl<Long, Mapa> implements MapaRepository {

	@Override
	public Class<Mapa> getClassDeT() {
		return Mapa.class;
	}

	@Override
	public String getNombreTabla() {
		return "Mapa";
	}
}
