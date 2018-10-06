package es.cic.curso.curso18.mascotastarcraft.repositoryImpl;

import es.cic.curso.curso18.mascotastarcraft.dominio.Mapa;
import es.cic.curso.curso18.mascotastarcraft.repository.MapaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
