package es.cic.curso.curso18.mascotastarcraft.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso18.mascotastarcraft.dominio.Base;
import es.cic.curso.curso18.mascotastarcraft.dominio.Mapa;
import es.cic.curso.curso18.mascotastarcraft.repository.BaseRepository;
import es.cic.curso.curso18.mascotastarcraft.repository.MapaRepository;
import es.cic.curso.curso18.mascotastarcraft.service.MapaService;

@Service
public class MapaServiceImpl implements MapaService {

	private MapaRepository mapaRepository;
	private BaseRepository baseRepository;

	@Autowired
	public void setBaseRepository(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Autowired
	public void setMapaRepository(MapaRepository mapaRepository) {
		this.mapaRepository = mapaRepository;
	}

	@Override
	public Long aniadirMapa(String nombreMapa, int basesMaximo, int jugadoresMaximo, boolean jugado, long idBase) {

		Mapa mapa = new Mapa();
		mapa.setNombreMapa(nombreMapa);
		mapa.setBasesMaximo(basesMaximo);
		mapa.setJugadoresMaximo(jugadoresMaximo);
		mapa.setJugado(jugado);
		Base base = baseRepository.read(idBase);
		mapa.setBase(base);
		Mapa aniadida = aniadirMapa(mapa);

		return aniadida.getId();

	}

	private Mapa aniadirMapa(Mapa nueva) {
		return mapaRepository.add(nueva);
	}

	@Override
	public Mapa actualizarMapa(Mapa modificada) {
		return mapaRepository.update(modificada);
	}

	@Override
	public void borrarMapa(Long id) {
		Mapa aBorrar = obtenerMapa(id);
		mapaRepository.delete(aBorrar);
	}

	@Override
	public Mapa obtenerMapa(Long id) {
		return mapaRepository.read(id);
	}

	@Override
	public List<Mapa> obtenerMapas() {
		return mapaRepository.list();
	}
}
