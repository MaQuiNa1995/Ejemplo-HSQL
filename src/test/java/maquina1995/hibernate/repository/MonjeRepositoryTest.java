package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2many.Monje;
import maquina1995.hibernate.repository.JpaRepository;
import maquina1995.hibernate.repository.one2many.MonjeRepository;

public class MonjeRepositoryTest extends JpaRepositoryImplTest<Long, Monje> {

	@Autowired
	private MonjeRepository cut;

	@Override
	public JpaRepository<Long, Monje> getRepository() {
		return cut;
	}

	@Override
	public Monje getInstanceDeT() {
		Monje monje = new Monje();
		monje.setNombre("MaKy1995");

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

}
