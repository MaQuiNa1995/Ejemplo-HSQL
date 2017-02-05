package es.cic.curso.curso18.mascotastarcraft.service.mapa;

import es.cic.curso.curso18.mascotastarcraft.Sitio.MapaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso18.mascotastarcraft.fortaleza.Base;
import es.cic.curso.curso18.mascotastarcraft.fortaleza.BaseRepository;

@Service
public class MapaServiceImpl implements MapaService {

    @Autowired
    private MapaRepository mapaRepository;

    @Autowired
    private BaseRepository baseRepository;

    @Override
    public Base actualizarMapa(Base modificada) {
    }

    @Override
    public Long aniadirMapa(int cantidadMineral, String tipoMineral, int TrabajadoresMaximo, long idTrabajador) {
    }

    @Override
    public void borrarMapa(Long id) {
    }

    @Override
    public Base obtenerMapa(Long id) {
    }

    @Override
    public List<Base> obtenerMapas() {
    }

}
