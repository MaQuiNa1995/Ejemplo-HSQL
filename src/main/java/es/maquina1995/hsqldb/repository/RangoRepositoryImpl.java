package es.maquina1995.hsqldb.repository;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Rango;

@Repository
public class RangoRepositoryImpl extends CrudRepositoryImpl<Long, Rango> implements RangoRepository {

    public static final String TABLA = "RANGO";

    @Override
    public Class<Rango> getClassDeT() {
	return Rango.class;
    }

    /**
     * Método usado para hacer el get del nombre de la tabla (Se hace get de una
     * variable public statica para los metodos abstractos del CrudRepository de
     * otra forma no sería posible hacer tan generica la clase)
     * 
     * @return {@link java.lang.String} del nombre de la tabla en base de datos que representa el dominio asociado de este repositorio
     * 
     */
    @Override
    public String getNombreTabla() {
	return TABLA;
    }
}