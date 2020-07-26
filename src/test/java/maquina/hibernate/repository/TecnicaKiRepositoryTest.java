package maquina.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina.hibernate.dominio.one2many.TecnicaKi;
import maquina.hibernate.repository.one2many.TecnicaKiRepository;

public class TecnicaKiRepositoryTest extends JpaRepositoryImplTest<Long, TecnicaKi> {

	@Autowired
	private TecnicaKiRepository cut;

	@Override
	public JpaRepository<Long, TecnicaKi> getRepository() {
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
