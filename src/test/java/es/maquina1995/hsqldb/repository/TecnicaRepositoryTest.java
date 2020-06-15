package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Rango;
import es.maquina1995.hsqldb.dominio.one2one.Tecnica;
import es.maquina1995.hsqldb.repository.one2one.TecnicaRepository;

public class TecnicaRepositoryTest extends CrudRepositoryImplTest<Long, Tecnica> {

	@Autowired
	private TecnicaRepository cut;

	@Override
	public CrudRepository<Long, Tecnica> getRepository() {
		return cut;
	}

	@Override
	public Tecnica getInstanceDeT() {
		Tecnica tecnica = new Tecnica();
		tecnica.setNombre("Robar");

		Rango rango = new Rango();
		rango.setNombre("Línea Recta");

		tecnica.setRango(rango);

		return tecnica;
	}

	@Override
	public boolean sonDatosIguales(Tecnica magia1, Tecnica magia2) {
		return magia1.equals(magia2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Tecnica getInstanceDeTParaModificar(Long clave) {
		Tecnica tecnica = super.getInstanceDeTParaModificar(clave);

		tecnica.getRango().setNombre("Arco Frontal");

		return tecnica;
	}

}
