package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Invocador;
import es.maquina1995.hsqldb.repository.one2many.InvocadorRepository;

public class InvocadorRepositoryTest extends CrudRepositoryImplTest<Long, Invocador> {

	@Autowired
	private InvocadorRepository cut;

	@Override
	public CrudRepository<Long, Invocador> getRepository() {
		return cut;
	}

	@Override
	public Invocador getInstanceDeT() {
		Invocador invocador = new Invocador();
		invocador.setNombre("MaKy1995");

		return invocador;
	}

	@Override
	public boolean sonDatosIguales(Invocador invocador, Invocador invocador2) {
		return invocador.equals(invocador2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

}
