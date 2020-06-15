package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Pocion;
import es.maquina1995.hsqldb.repository.one2many.PocionRepository;

@Disabled
public class PocionRepositoryTest extends CrudRepositoryImplTest<Long, Pocion> {

	@Autowired
	private PocionRepository cut;

	@Override
	public CrudRepository<Long, Pocion> getRepository() {
		return cut;
	}

	// TODO revisar error conocido
	@Override
	public Pocion getInstanceDeT() {
		Pocion pocion = new Pocion();
		pocion.setNombre("Elixir");

//		Alquimista alquimista = new Alquimista();
//		alquimista.setNombre("MaQuiNa1995");
//		pocion.setAlquimista(alquimista);

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

	// TODO revisar
//	@Override
//	protected Pocion getInstanceDeTParaModificar(Long id) {
//		Pocion personaje = super.getInstanceDeTParaModificar(id);
//
//		personaje.getAlquimista().setNombre("MaKy1995");
//
//		return personaje;
//	}

}
