package es.cic.curso.curso18.mascotastarcraft.service.mapa;

import es.cic.curso.curso18.mascotastarcraft.service.base.*;
import es.cic.curso.curso18.mascotastarcraft.fortaleza.Base;
import java.util.List;

public interface MapaService {

    Base actualizarMapa(Base modificada);

    Long aniadirMapa(int cantidadMineral, String tipoMineral, int TrabajadoresMaximo, long idTrabajador);

    void borrarMapa(Long id);

    Base obtenerMapa(Long id);

    List<Base> obtenerMapas();
    
}
