package es.maquina1995.hsqldb.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Trabajador;

@Repository
@Transactional
public class TrabajadorRepositoryImpl extends GenericCrudRepositoryImpl<Long, Trabajador> implements TrabajadorRepository {

	@Override
	public Class<Trabajador> getClassDeT() {
		return Trabajador.class;
	}

	@Override
	public String getNombreTabla() {
		return "Trabajador";
	}
}
