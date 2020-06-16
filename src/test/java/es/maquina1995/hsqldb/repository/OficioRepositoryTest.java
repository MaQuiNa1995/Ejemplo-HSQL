package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Alquimista;
import es.maquina1995.hsqldb.dominio.one2one.Oficio;
import es.maquina1995.hsqldb.dominio.one2one.Personaje;
import es.maquina1995.hsqldb.repository.one2one.OficioRepository;

public class OficioRepositoryTest extends CrudRepositoryImplTest<Long, Oficio> {

	@Autowired
	private OficioRepository cut;

	@Override
	public CrudRepository<Long, Oficio> getRepository() {
		return cut;
	}

	/**
	 * Al ser la parte esclava de la relación no se puede persistir un objeto
	 * {@link Oficio} que tenga asociado un {@link Personaje} si queremos asociarles
	 * deberemos persistir previamente un {@link Personaje} y luego al persistir el
	 * {@link Oficio} enlazarles
	 * <p>
	 * {@link Personaje#getOficio()} En este caso la relacion dictamina que este
	 * valor no puede ser nulable asique primero deberíamos hacer el persist de un
	 * {@link Alquimista} y luego persistir el objeto {@link Personaje} habiendo
	 * previamente hecho el {@link Personaje#setOficio(Oficio)}
	 */
	@Override
	public Oficio getInstanceDeT() {
		Oficio oficio = new Oficio();
		oficio.setNombre("Dragontino");

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

}
