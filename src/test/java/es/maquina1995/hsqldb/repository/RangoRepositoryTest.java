package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Rango;
import es.maquina1995.hsqldb.dominio.one2one.Tecnica;
import es.maquina1995.hsqldb.repository.one2one.RangoRepository;

public class RangoRepositoryTest extends CrudRepositoryImplTest<Long, Rango> {

	private RangoRepository cut;
	private Tecnica tecnica;

	@BeforeEach
	public void setUp() {

		this.tecnica = new Tecnica();
		this.tecnica.setNombre("Imitar");

	}

	@Override
	public CrudRepository<Long, Rango> getRepository() {
		return this.cut;
	}

	@Override
	public Rango getInstanceDeT() {
		Rango rango = new Rango();
		rango.setNombre("Línea Recta");
		rango.setTecnica(this.tecnica);

		return rango;
	}

	@Override
	public boolean sonDatosIguales(Rango rango1, Rango rango2) {
		return rango1.equals(rango2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Rango getInstanceDeTParaModificar(Long clave) {
		Rango rango = new Rango();
		rango.setNombre("Arco Frontal");
		rango.setId(clave);

		this.tecnica.setNombre("Puño Airoso");
		rango.setTecnica(this.tecnica);

		return rango;
	}

	@Autowired
	public void setRangoRepository(RangoRepository sut) {
		this.cut = sut;
	}
}
