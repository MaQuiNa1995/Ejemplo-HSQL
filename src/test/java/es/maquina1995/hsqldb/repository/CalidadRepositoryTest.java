package es.maquina1995.hsqldb.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.many2many.Arma;
import es.maquina1995.hsqldb.dominio.many2many.Calidad;
import es.maquina1995.hsqldb.repository.many2many.CalidadRepository;

public class CalidadRepositoryTest extends CrudRepositoryImplTest<Long, Calidad> {

	@Autowired
	private CalidadRepository cut;

	@Override
	public CrudRepository<Long, Calidad> getRepository() {
		return cut;
	}

	/**
	 * Al ser la parte esclava de la relación no se puede persistir un objeto
	 * {@link Arma} que tenga asociado un {@link Calidad} si queremos asociarles
	 * deberemos persistir previamente un {@link Calidad} y luego al persistir el
	 * {@link Arma} enlazarles
	 * <p>
	 * Lo primero deberíamos hacer el persist de un {@link Arma} y luego persistir
	 * el objeto {@link Calidad} habiendo previamente hecho el
	 * {@link Calidad#setArmas(java.util.List)}
	 */
	@Override
	public Calidad getInstanceDeT() {
		Calidad calidad = new Calidad();
		calidad.setNombre("Estropeado");

		return calidad;
	}

	@Override
	public boolean sonDatosIguales(Calidad bestia, Calidad bestia2) {
		return bestia.equals(bestia2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Calidad getInstanceDeTParaModificar(Long clave) {
		Calidad calidad = super.getInstanceDeTParaModificar(clave);

		Arma arma = new Arma();
		arma.setNombre("Excalibur");

		calidad.setArmas(Arrays.asList(arma));

		return calidad;
	}

}
