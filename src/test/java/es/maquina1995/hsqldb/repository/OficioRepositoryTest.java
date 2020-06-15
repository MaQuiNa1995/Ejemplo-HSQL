package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Oficio;
import es.maquina1995.hsqldb.repository.one2one.OficioRepository;

public class OficioRepositoryTest extends CrudRepositoryImplTest<Long, Oficio> {

	@Autowired
	private OficioRepository cut;

	@Override
	public CrudRepository<Long, Oficio> getRepository() {
		return cut;
	}

	@Override
	public Oficio getInstanceDeT() {
		Oficio oficio = new Oficio();
		oficio.setNombre("Dragontino");

//		Personaje personaje = new Personaje();
//		personaje.setNombre("MaQuiNa1995");
//
//		oficio.setPersonaje(personaje);
		return oficio;
	}

	@Override
	public boolean sonDatosIguales(Oficio oficio1, Oficio oficio2) {
		return oficio1.equals(oficio2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	// TODO revisar porque al meter un personaje peta por
	// not-null property references a null or transient value
	@Override
	protected Oficio getInstanceDeTParaModificar(Long id) {
		Oficio oficio = super.getInstanceDeTParaModificar(id);

//		Personaje personaje = new Personaje();
//		personaje.setNombre("Maqui1995");
//		oficio.setPersonaje(personaje);

		return oficio;
	}

}
