package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.TecnicaKi;
import es.maquina1995.hsqldb.repository.one2many.TecnicaKiRepository;

public class TecnicaKiRepositoryTest extends CrudRepositoryImplTest<Long, TecnicaKi> {

	@Autowired
	private TecnicaKiRepository cut;

	@Override
	public CrudRepository<Long, TecnicaKi> getRepository() {
		return cut;
	}

	@Override
	public TecnicaKi getInstanceDeT() {
		TecnicaKi tecnicaKi = new TecnicaKi();
		tecnicaKi.setNombre("Robar");

		return tecnicaKi;
	}

	@Override
	public boolean sonDatosIguales(TecnicaKi tecnicaKi1, TecnicaKi tecnicaKi2) {
		return tecnicaKi1.equals(tecnicaKi2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

}
