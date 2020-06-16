package es.maquina1995.hsqldb.repository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.many2many.Arma;
import es.maquina1995.hsqldb.dominio.many2many.Calidad;
import es.maquina1995.hsqldb.repository.many2many.ArmaRepository;

public class ArmaRepositoryTest extends CrudRepositoryImplTest<Long, Arma> {

	@Autowired
	private ArmaRepository cut;

	@Override
	public CrudRepository<Long, Arma> getRepository() {
		return cut;
	}

	@Override
	public Arma getInstanceDeT() {
		Arma arma = new Arma();
		arma.setNombre("Excalibur");

		Calidad calidad = new Calidad();
		calidad.setNombre("Quimera");

		arma.setCalidades(Stream.of(calidad).collect(Collectors.toSet()));

		return arma;
	}

	@Override
	public boolean sonDatosIguales(Arma bestia, Arma bestia2) {
		return bestia.equals(bestia2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Arma getInstanceDeTParaModificar(Long clave) {
		Arma arma = super.getInstanceDeTParaModificar(clave);

		Calidad calidad = new Calidad();
		calidad.setNombre("Legendario");

		arma.getCalidades().clear();
		arma.getCalidades().add(calidad);

		return arma;
	}

}
