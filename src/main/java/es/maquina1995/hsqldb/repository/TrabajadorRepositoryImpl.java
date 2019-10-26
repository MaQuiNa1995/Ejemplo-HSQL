package es.maquina1995.hsqldb.repository;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Trabajador;

@Repository
public class TrabajadorRepositoryImpl extends CrudRepositoryImpl<Long, Trabajador> implements TrabajadorRepository {

    @Override
    public Class<Trabajador> getClassDeT() {
	return Trabajador.class;
    }

    @Override
    public String getNombreTabla() {
	return "TRABAJADOR";
    }
}
