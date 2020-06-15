package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Monje;
import es.maquina1995.hsqldb.repository.one2many.MonjeRepository;

public class MonjeRepositoryTest extends CrudRepositoryImplTest<Long, Monje> {

	@Autowired
	private MonjeRepository cut;

	@Override
	public CrudRepository<Long, Monje> getRepository() {
		return cut;
	}

	// TODO revisar
	@Override
	public Monje getInstanceDeT() {
		Monje monje = new Monje();
		monje.setNombre("MaKy1995");

//		TecnicaKi tecnicaKi = new TecnicaKi();
//		tecnicaKi.setNombre("Chakra");
//
//		monje.setTecnicas(Arrays.asList(tecnicaKi));

		return monje;
	}

	@Override
	public boolean sonDatosIguales(Monje monje, Monje monje2) {
		return monje.equals(monje2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	// TODO revisar
//	@Override
//	protected Monje getInstanceDeTParaModificar(Long id) {
//		Monje monje = super.getInstanceDeTParaModificar(id);
//
//		TecnicaKi tecnicaKi = new TecnicaKi();
//		tecnicaKi.setNombre("Mil Puños");
//
//		monje.setTecnicas(Arrays.asList(tecnicaKi));
//
//		return monje;
//	}

}
