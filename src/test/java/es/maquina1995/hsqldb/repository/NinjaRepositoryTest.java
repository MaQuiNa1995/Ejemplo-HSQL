package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Ninja;
import es.maquina1995.hsqldb.dominio.one2one.Ninjutsu;
import es.maquina1995.hsqldb.repository.one2one.NinjaRepository;

public class NinjaRepositoryTest extends CrudRepositoryImplTest<Long, Ninja> {

	private NinjaRepository cut;

	@Override
	public CrudRepository<Long, Ninja> getRepository() {
		return cut;
	}

	@Override
	public Ninja getInstanceDeT() {
		Ninja ninja = new Ninja();
		ninja.setNombre("Ninja Sepulcrador");

		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Última pesadilla");

		ninja.setNinjutsu(ninjutsu);
		return ninja;
	}

	@Override
	public boolean sonDatosIguales(Ninja ninja1, Ninja ninja2) {
		return ninja1.equals(ninja2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Ninja getInstanceDeTParaModificar(Long clave) {
		Ninja ninja = getInstanceDeT();
		ninja.setId(clave);
		ninja.setNombre("Ninja De Las Sombras");

		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Puño Mortífero");

		return ninja;
	}

	@Autowired
	public void setNinjaRepository(NinjaRepository cut) {
		this.cut = cut;
	}
}
