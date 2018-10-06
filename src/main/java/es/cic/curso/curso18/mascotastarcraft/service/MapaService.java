package es.cic.curso.curso18.mascotastarcraft.service;

import java.util.List;

import es.cic.curso.curso18.mascotastarcraft.dominio.Mapa;

public interface MapaService {

    public Mapa actualizarMapa(Mapa modificada);

    public Long aniadirMapa(String nombreMapa, int basesMaximo, int jugadoresMaximo, boolean jugado, long idBase);

    public void borrarMapa(Long id);

    public Mapa obtenerMapa(Long id);

    public List<Mapa> obtenerMapas();
    
}
