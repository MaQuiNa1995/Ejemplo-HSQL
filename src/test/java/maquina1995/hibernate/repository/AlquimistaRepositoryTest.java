package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2many.Alquimista;
import maquina1995.hibernate.dominio.one2many.Pocion;
import maquina1995.hibernate.repository.JpaRepository;
import maquina1995.hibernate.repository.one2many.AlquimistaRepository;

public class AlquimistaRepositoryTest extends JpaRepositoryImplTest<Long, Alquimista> {

	@Autowired
	private AlquimistaRepository cut;

	@Override
	public JpaRepository<Long, Alquimista> getRepository() {
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
	public Alquimista getInstanceDeT() {

		Alquimista alquimista = new Alquimista();
		alquimista.setNombre("MaquiNa1995");

		return alquimista;
	}

	@Override
	public boolean sonDatosIguales(Alquimista invocador, Alquimista invocador2) {
		return invocador.equals(invocador2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

}
