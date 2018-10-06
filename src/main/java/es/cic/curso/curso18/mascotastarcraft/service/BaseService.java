package es.cic.curso.curso18.mascotastarcraft.service;

import java.util.List;

import es.cic.curso.curso18.mascotastarcraft.dominio.Base;

public interface BaseService {

	public Base actualizarBase(Base modificada);

	public Long aniadirBase(int cantidadMineral, String tipoMineral, int TrabajadoresMaximo, long idTrabajador);

	public void borrarBase(Long id);

	public Base obtenerBase(Long id);

	public List<Base> obtenerBases();
    
}
