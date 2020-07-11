package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2one.Mago;
import maquina1995.hibernate.dominio.one2one.TipoMagia;
import maquina1995.hibernate.repository.JpaRepository;
import maquina1995.hibernate.repository.one2one.TipoMagiaRepository;

public class TipoMagiaRepositoryTest extends JpaRepositoryImplTest<Long, TipoMagia> {

	@Autowired
	private TipoMagiaRepository cut;

	@Override
	public JpaRepository<Long, TipoMagia> getRepository() {
		return cut;
	}

	@Override
	public TipoMagia getInstanceDeT() {
		TipoMagia tipoMagia = new TipoMagia();
		tipoMagia.setNombre("Magia Roja");

		Mago mago = new Mago();
		mago.setNombre("Mago Rojo");

		tipoMagia.setMago(mago);

		return tipoMagia;
	}

	@Override
	public boolean sonDatosIguales(TipoMagia tipoMagia1, TipoMagia tipoMagia2) {
		return tipoMagia1.equals(tipoMagia2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public TipoMagia getInstanceDeTParaModificar(Long clave) {
		TipoMagia tipoMagia = super.getInstanceDeTParaModificar(clave);

		tipoMagia.getMago().setNombre("Mago Blanco");

		return tipoMagia;
	}

}
