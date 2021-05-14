package maquina.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina.hibernate.dominio.one2one.Oficio;
import maquina.hibernate.dominio.one2one.Personaje;
import maquina.hibernate.repository.one2one.PersonajeRepository;

public class PersonajeRepositoryTest extends JpaRepositoryImplTest<Long, Personaje> {

	@Autowired
	private PersonajeRepository cut;

	@Override
	public CustomGenericRepository<Long, Personaje> getRepository() {
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

		personaje.getOficio()
				.setNombre("Ilusionista");

		return personaje;
	}

}
