package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2one.Ninjutsu;
import maquina1995.hibernate.repository.CrudRepository;
import maquina1995.hibernate.repository.one2one.NinjutsuRepository;

public class NinjutsuRepositoryTest extends CrudRepositoryImplTest<Long, Ninjutsu> {

	@Autowired
	private NinjutsuRepository cut;

	@Override
	public CrudRepository<Long, Ninjutsu> getRepository() {
		return cut;
	}

	@Override
	public Ninjutsu getInstanceDeT() {
		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Ultima Pesadilla");

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

}
