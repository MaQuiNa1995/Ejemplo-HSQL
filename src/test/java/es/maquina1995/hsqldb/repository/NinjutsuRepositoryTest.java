package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Ninja;
import es.maquina1995.hsqldb.dominio.one2one.Ninjutsu;
import es.maquina1995.hsqldb.repository.one2one.NinjutsuRepository;

public class NinjutsuRepositoryTest extends CrudRepositoryImplTest<Long, Ninjutsu> {

	private NinjutsuRepository cut;

	@Override
	public CrudRepository<Long, Ninjutsu> getRepository() {
		return cut;
	}

	@Override
	public Ninjutsu getInstanceDeT() {
		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Ultima Pesadilla");

		Ninja ninja = new Ninja();
		ninja.setNombre("Ninja Sepulcral");
		ninja.setNinjutsu(ninjutsu);

		return ninjutsu;
	}

	@Override
	public boolean sonDatosIguales(Ninjutsu ninjutsu, Ninjutsu ninjutsu2) {
		return ninjutsu.equals(ninjutsu2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Ninjutsu getInstanceDeTParaModificar(Long clave) {
		Ninjutsu ninjutsu = getInstanceDeT();
		ninjutsu.setId(clave);
		ninjutsu.setNombre("Puño Mortífero");

		Ninja ninja = new Ninja();
		ninja.setNombre("Ninja De las Sombras");
		ninja.setNinjutsu(ninjutsu);

		return ninjutsu;
	}

	@Autowired
	public void setNinjutsuRepository(NinjutsuRepository cut) {
		this.cut = cut;
	}
}
