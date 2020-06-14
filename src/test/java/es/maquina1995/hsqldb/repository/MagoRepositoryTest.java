package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Mago;
import es.maquina1995.hsqldb.repository.one2one.MagoRepository;

public class MagoRepositoryTest extends CrudRepositoryImplTest<Long, Mago> {

	private MagoRepository cut;

	@Override
	public CrudRepository<Long, Mago> getRepository() {
		return cut;
	}

	@Override
	public Mago getInstanceDeT() {
		Mago mago = new Mago();
		mago.setNombre("Mago Negro");

		return mago;
	}

	@Override
	public boolean sonDatosIguales(Mago mago1, Mago mago2) {
		return mago1.equals(mago2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Mago getInstanceDeTParaModificar(Long clave) {
		Mago mago = getInstanceDeT();
		mago.setId(clave);
		mago.setNombre("Mago Rojo");

		return mago;
	}

	@Autowired
	public void setMagoRepository(MagoRepository sut) {
		this.cut = sut;
	}
}
