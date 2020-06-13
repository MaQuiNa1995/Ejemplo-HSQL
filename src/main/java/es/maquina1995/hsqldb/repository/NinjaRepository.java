package es.maquina1995.hsqldb.repository;

import es.maquina1995.hsqldb.dominio.one2one.Ninja;

public interface NinjaRepository
		extends CrudRepository < Long, Ninja >
{

	@Override
	Class < Ninja > getClassDeT ( );

	/**
	 * Método usado para hacer el get del nombre de la tabla (Se hace get de una variable public statica para los metodos abstractos del CrudRepository de otra forma no sería posible hacer tan generica la clase)
	 * 
	 * @return {@link java.lang.String} del nombre de la tabla en base de datos que representa el dominio asociado de este repositorio
	 * 
	 */
	@Override
	String getNombreTabla ( );

}