package es.maquina1995.hsqldb.repositoryImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;

@Repository
@Transactional
public class TrabajadorRepositoryImpl extends AbstractRepositoryImpl<Long, Trabajador> implements TrabajadorRepository {

	@Override
	public Class<Trabajador> getClassDeT() {
		return Trabajador.class;
	}

	@Override
	public String getNombreTabla() {
		return "Trabajador";
	}
}
