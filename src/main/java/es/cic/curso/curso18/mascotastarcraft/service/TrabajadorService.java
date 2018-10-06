package es.cic.curso.curso18.mascotastarcraft.service;

import java.util.List;

import es.cic.curso.curso18.mascotastarcraft.dominio.Trabajador;

public interface TrabajadorService {

	public Trabajador actualizarTrabajador(Trabajador modificada);

	public Long aniadirTrabajador(String tipoTrabajador);

	public void borrarTrabajador(Long id);

	public Trabajador obtenerTrabajador(Long id);

	public List<Trabajador> obtenerTrabajadors();
    
}
