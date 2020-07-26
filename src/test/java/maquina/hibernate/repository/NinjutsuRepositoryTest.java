package maquina.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.repository.one2one.NinjutsuRepository;

public class NinjutsuRepositoryTest extends JpaRepositoryImplTest<Long, Ninjutsu> {

	@Autowired
	private NinjutsuRepository cut;

	@Override
	public JpaRepository<Long, Ninjutsu> getRepository() {
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
