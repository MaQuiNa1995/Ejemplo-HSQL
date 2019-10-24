package es.maquina1995.hsqldb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina1995.hsqldb.dominio.Base;
import es.maquina1995.hsqldb.dominio.Mapa;
import es.maquina1995.hsqldb.repository.BaseRepository;
import es.maquina1995.hsqldb.repository.MapaRepository;

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
		Base base = baseRepository.readByPk(idBase);
		mapa.setBase(base);
		Mapa aniadida = aniadirMapa(mapa);

		return aniadida.getId();

	}

	private Mapa aniadirMapa(Mapa nueva) {
		return mapaRepository.persist(nueva);
	}

	@Override
	public Mapa actualizarMapa(Mapa modificada) {
		return mapaRepository.merge(modificada);
	}

	@Override
	public void borrarMapa(Long id) {
		Mapa aBorrar = obtenerMapa(id);
		mapaRepository.delete(aBorrar);
	}

	@Override
	public Mapa obtenerMapa(Long id) {
		return mapaRepository.readByPk(id);
	}

	@Override
	public List<Mapa> obtenerMapas() {
		return mapaRepository.findAll();
	}
}
