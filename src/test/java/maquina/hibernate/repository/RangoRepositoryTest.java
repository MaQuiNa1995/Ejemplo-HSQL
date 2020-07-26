package maquina.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina.hibernate.dominio.one2one.Rango;
import maquina.hibernate.dominio.one2one.Tecnica;
import maquina.hibernate.repository.one2one.RangoRepository;

public class RangoRepositoryTest extends JpaRepositoryImplTest<Long, Rango> {

	@Autowired
	private RangoRepository cut;

	@Override
	public JpaRepository<Long, Rango> getRepository() {
		return cut;
	}

	@Override
	public Rango getInstanceDeT() {
		Rango rango = new Rango();
		rango.setNombre("Línea Recta");

		Tecnica tecnica = new Tecnica();
		tecnica.setNombre("Imitar");

		rango.setTecnica(tecnica);

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
		Rango rango = super.getInstanceDeTParaModificar(clave);

		rango.getTecnica()
				.setNombre("Lluvia De Puños");

		return rango;
	}

}
