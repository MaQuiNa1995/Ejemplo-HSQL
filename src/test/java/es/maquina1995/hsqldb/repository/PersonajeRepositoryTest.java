package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Oficio;
import es.maquina1995.hsqldb.dominio.one2one.Personaje;
import es.maquina1995.hsqldb.repository.one2one.PersonajeRepository;

public class PersonajeRepositoryTest extends CrudRepositoryImplTest<Long, Personaje> {

	@Autowired
	private PersonajeRepository cut;

	@Override
	public CrudRepository<Long, Personaje> getRepository() {
		return cut;
	}

	@Override
	public Personaje getInstanceDeT() {
		Personaje personaje = new Personaje();
		personaje.setNombre("MaQuiNa1995");

		Oficio oficio = new Oficio();
		oficio.setNombre("Paladín");

		personaje.setOficio(oficio);
		return personaje;
	}

	@Override
	public boolean sonDatosIguales(Personaje personaje1, Personaje personaje2) {
		return personaje1.equals(personaje2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	protected Personaje getInstanceDeTParaModificar(Long id) {
		Personaje personaje = super.getInstanceDeTParaModificar(id);

		personaje.getOficio().setNombre("Ilusionista");

		return personaje;
	}

}
