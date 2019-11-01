package es.maquina1995.hsqldb.repository;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Trabajador;

public interface TrabajadorRepository extends CrudRepository<Long, Trabajador> {

    List<Trabajador> findTrabajadoresByPk(long... idTrabajadores);

}
