package es.maquina1995.hsqldb.service;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Trabajador;

public interface TrabajadorService {

	public Trabajador actualizarTrabajador(Trabajador modificada);

	public Long aniadirTrabajador(String tipoTrabajador);

	public void borrarTrabajador(Long id);

	public Trabajador obtenerTrabajador(Long id);

	public List<Trabajador> obtenerTrabajadores();
    
}
