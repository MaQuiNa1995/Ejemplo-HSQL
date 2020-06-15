package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2many.Alquimista;
import es.maquina1995.hsqldb.repository.one2many.AlquimistaRepository;

public class AlquimistaRepositoryTest extends CrudRepositoryImplTest<Long, Alquimista> {

	@Autowired
	private AlquimistaRepository cut;

	@Override
	public CrudRepository<Long, Alquimista> getRepository() {
		return cut;
	}

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
