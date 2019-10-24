package es.maquina1995.hsqldb.serviceimpl;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Mapa;

public interface MapaService {

    public Mapa actualizarMapa(Mapa modificada);

    public Long aniadirMapa(String nombreMapa, int basesMaximo, int jugadoresMaximo, boolean jugado, long idBase);

    public void borrarMapa(Long id);

    public Mapa obtenerMapa(Long id);

    public List<Mapa> obtenerMapas();
    
}
