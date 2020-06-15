package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.InvocacionSuprema;
import es.maquina1995.hsqldb.repository.one2many.InvocacionSupremaRepository;

public class InvocacionSupremaRepositoryTest extends CrudRepositoryImplTest<Long, InvocacionSuprema> {

	@Autowired
	private InvocacionSupremaRepository cut;

	@Override
	public CrudRepository<Long, InvocacionSuprema> getRepository() {
		return cut;
	}

	// TODO revisar
	@Override
	public InvocacionSuprema getInstanceDeT() {

		InvocacionSuprema invocacionSuprema = new InvocacionSuprema();
		invocacionSuprema.setNombre("Bahamut");

//		Invocador invocador = new Invocador();
//		invocador.setNombre("MaKy1995");
//
//		invocacionSuprema.setInvocador(invocador);

		return invocacionSuprema;
	}

	@Override
	public boolean sonDatosIguales(InvocacionSuprema invocador, InvocacionSuprema invocador2) {
		return invocador.equals(invocador2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	// TODO revisar
	@Override
	protected InvocacionSuprema getInstanceDeTParaModificar(Long id) {
		InvocacionSuprema invocacionSuprema = super.getInstanceDeTParaModificar(id);

//		Invocador invocador = new Invocador();
//		invocador.setNombre("MaQui1995");
//
//		invocacionSuprema.setInvocador(invocador);

		return invocacionSuprema;
	}

}
