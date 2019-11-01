package es.maquina1995.hsqldb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Trabajador;

@Repository
public class TrabajadorRepositoryImpl extends CrudRepositoryImpl<Long, Trabajador> implements TrabajadorRepository {

    public static final String FIND_TRABAJADORES_BY_PK = "Trabajador.findTrabajadoresByPk";

    @Override
    public List<Trabajador> findTrabajadoresByPk(long... idTrabajadores) {

	return getEntityManager().createNamedQuery(FIND_TRABAJADORES_BY_PK, getClassDeT())
		.setParameter("arrayId", idTrabajadores).getResultList();

    }

    @Override
    public Class<Trabajador> getClassDeT() {
	return Trabajador.class;
    }

    @Override
    public String getNombreTabla() {
	return "TRABAJADOR";
    }
}
