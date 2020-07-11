package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2many.InvocacionSuprema;
import maquina1995.hibernate.dominio.one2many.Invocador;
import maquina1995.hibernate.repository.one2many.InvocacionSupremaRepository;

public class InvocacionSupremaRepositoryTest extends JpaRepositoryImplTest<Long, InvocacionSuprema> {

	@Autowired
	private InvocacionSupremaRepository cut;

	@Override
	public JpaRepository<Long, InvocacionSuprema> getRepository() {
		return cut;
	}

	/**
	 * Al ser la parte esclava de la relación no se puede persistir un objeto
	 * {@link InvocacionSuprema} que tenga asociado un {@link Invocador} si queremos
	 * asociarles deberemos persistir previamente un {@link Invocador} y luego al
	 * persistir el {@link InvocacionSuprema} enlazarles como muestro en el método
	 */
	@Override
	public InvocacionSuprema getInstanceDeT() {

		InvocacionSuprema invocacionSuprema = new InvocacionSuprema();
		invocacionSuprema.setNombre("Bahamut");

		Invocador invocador = new Invocador();
		invocador.setNombre("MaKy1995");
		entityManager.persist(invocador);

		invocacionSuprema.setInvocador(invocador);

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

	@Override
	protected InvocacionSuprema getInstanceDeTParaModificar(Long id) {
		InvocacionSuprema invocacionSuprema = super.getInstanceDeTParaModificar(id);

		invocacionSuprema.getInvocador()
				.setNombre("MaQui1995");

		return invocacionSuprema;
	}

}
