package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.many2many.Bestia;
import es.maquina1995.hsqldb.repository.many2many.BestiaRepository;

public class BestiaRepositoryTest extends CrudRepositoryImplTest<Long, Bestia> {

	@Autowired
	private BestiaRepository cut;

	@Override
	public CrudRepository<Long, Bestia> getRepository() {
		return cut;
	}

	@Override
	public Bestia getInstanceDeT() {
		Bestia bestia = new Bestia();
		bestia.setNombre("Gran Molbo");

		return bestia;
	}

	@Override
	public boolean sonDatosIguales(Bestia bestia, Bestia bestia2) {
		return bestia.equals(bestia2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

}
