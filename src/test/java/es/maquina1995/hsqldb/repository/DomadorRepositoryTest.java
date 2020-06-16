package es.maquina1995.hsqldb.repository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.many2many.Bestia;
import es.maquina1995.hsqldb.dominio.many2many.Domador;
import es.maquina1995.hsqldb.repository.many2many.DomadorRepository;

public class DomadorRepositoryTest extends CrudRepositoryImplTest<Long, Domador> {

	@Autowired
	private DomadorRepository cut;

	@Override
	public CrudRepository<Long, Domador> getRepository() {
		return cut;
	}

	@Override
	public Domador getInstanceDeT() {
		Domador domador = new Domador();
		domador.setNombre("Domador Sepulcrador");

		Bestia bestia = new Bestia();
		bestia.setNombre("Quimera");

		domador.setBestias(Stream.of(bestia).collect(Collectors.toSet()));

		return domador;
	}

	@Override
	public boolean sonDatosIguales(Domador domador, Domador domador2) {
		return domador.equals(domador2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Domador getInstanceDeTParaModificar(Long clave) {
		Domador domador = super.getInstanceDeTParaModificar(clave);

		domador.getBestias().forEach(e -> e.setNombre("Antoleón"));

		return domador;
	}

}
