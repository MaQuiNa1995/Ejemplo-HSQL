package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Alquimista;
import es.maquina1995.hsqldb.dominio.one2many.Pocion;
import es.maquina1995.hsqldb.repository.one2many.PocionRepository;

public class PocionRepositoryTest extends CrudRepositoryImplTest<Long, Pocion> {

	@Autowired
	private PocionRepository cut;

	@Override
	public CrudRepository<Long, Pocion> getRepository() {
		return cut;
	}

	/**
	 * Al ser la parte esclava de la relación no se puede persistir un objeto
	 * {@link Alquimista} que tenga asociado un {@link Pocion} si queremos
	 * asociarles deberemos persistir previamente un {@link Pocion} y luego al
	 * persistir el {@link Alquimista} enlazarles
	 * <p>
	 * {@link Pocion#getAlquimista()} En este caso la relacion dictamina que este
	 * valor no puede ser nulable asique primero deberíamos hacer el persist de un
	 * {@link Alquimista} y luego persistir el objeto {@link Pocion} habiendo
	 * previamente hecho el {@link Pocion#setAlquimista(Alquimista)}
	 */
	@Override
	public Pocion getInstanceDeT() {
		Pocion pocion = new Pocion();
		pocion.setNombre("Elixir");

		Alquimista alquimista = new Alquimista();
		alquimista.setNombre("MaQuiNa1995");
		entityManager.persist(alquimista);

		pocion.setAlquimista(alquimista);

		return pocion;
	}

	@Override
	public boolean sonDatosIguales(Pocion pocion, Pocion pocion2) {
		return pocion.equals(pocion2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	protected Pocion getInstanceDeTParaModificar(Long id) {
		Pocion personaje = super.getInstanceDeTParaModificar(id);

		personaje.getAlquimista().setNombre("MaKy1995");

		return personaje;
	}

}
