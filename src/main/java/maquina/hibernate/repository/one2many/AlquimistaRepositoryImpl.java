package maquina.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina.hibernate.dominio.one2many.Alquimista;
import maquina.hibernate.repository.JpaRepositoryImpl;

@Repository
public class AlquimistaRepositoryImpl extends JpaRepositoryImpl<Long, Alquimista> implements AlquimistaRepository {

	@Override
	public Class<Alquimista> getClassDeT() {
		return Alquimista.class;
	}
}