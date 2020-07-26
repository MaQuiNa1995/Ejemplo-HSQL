package maquina.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina.hibernate.dominio.one2one.Rango;
import maquina.hibernate.dominio.one2one.Tecnica;
import maquina.hibernate.repository.one2one.TecnicaRepository;

public class TecnicaRepositoryTest extends JpaRepositoryImplTest<Long, Tecnica> {

	@Autowired
	private TecnicaRepository cut;

	@Override
	public JpaRepository<Long, Tecnica> getRepository() {
		return cut;
	}

	@Override
	public Tecnica getInstanceDeT() {
		Tecnica tecnica = new Tecnica();
		tecnica.setNombre("Robar");

		Rango rango = new Rango();
		rango.setNombre("Línea Recta");

		tecnica.setRango(rango);

		return tecnica;
	}

	@Override
	public boolean sonDatosIguales(Tecnica tecnica1, Tecnica tecnica2) {
		return tecnica1.equals(tecnica2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Tecnica getInstanceDeTParaModificar(Long clave) {
		Tecnica tecnica = super.getInstanceDeTParaModificar(clave);

		tecnica.getRango()
				.setNombre("Arco Frontal");

		return tecnica;
	}

}
