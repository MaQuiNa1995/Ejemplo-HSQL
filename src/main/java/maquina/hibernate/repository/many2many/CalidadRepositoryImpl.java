package maquina.hibernate.repository.many2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.many2many.Calidad;
import maquina.hibernate.repository.CustomGenericRepositoryImpl;

@Repository
public class CalidadRepositoryImpl extends CustomGenericRepositoryImpl<Long, Calidad> implements CalidadRepository {

	@Override
	public Class<Calidad> getClassDeT() {
		return Calidad.class;
	}
}