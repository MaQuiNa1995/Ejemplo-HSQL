package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2one.Mago;
import maquina1995.hibernate.repository.one2one.MagoRepository;

public class MagoRepositoryTest extends JpaRepositoryImplTest<Long, Mago> {

	@Autowired
	private MagoRepository cut;

	@Override
	public JpaRepository<Long, Mago> getRepository() {
		return cut;
	}

	@Override
	public Mago getInstanceDeT() {
		Mago mago = new Mago();
		mago.setNombre("Natsu");
		return mago;
	}

	@Override
	public boolean sonDatosIguales(Mago mago, Mago mago2) {
		return mago.equals(mago2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

}
