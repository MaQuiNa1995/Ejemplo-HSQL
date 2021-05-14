package maquina.hibernate.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import maquina.hibernate.dominio.one2one.Ninja;
import maquina.hibernate.dominio.one2one.Ninjutsu;
import maquina.hibernate.dto.NinjaNinjutsuDto;
import maquina.hibernate.repository.one2one.NinjaRepository;

class NinjaRepositoryTest extends JpaRepositoryImplTest<Long, Ninja> {

	@Autowired
	private NinjaRepository cut;

	@Override
	public CustomGenericRepository<Long, Ninja> getRepository() {
		return cut;
	}

	@Override
	public Ninja getInstanceDeT() {
		Ninja ninja = new Ninja();
		ninja.setNombre("Ninja Sepulcrador");

		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Última pesadilla");

		ninja.setNinjutsu(ninjutsu);
		return ninja;
	}

	@Override
	public boolean sonDatosIguales(Ninja ninja1, Ninja ninja2) {
		return ninja1.equals(ninja2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Ninja getInstanceDeTParaModificar(Long clave) {
		Ninja ninja = super.getInstanceDeTParaModificar(clave);

		ninja.getNinjutsu()
				.setNombre("Puño Sombrío");

		return ninja;
	}

	/**
	 * Ejemplo de query de proyección en la que se obtiene el
	 * {@link Ninja#getNombre()} y {@link Ninjutsu#getNombre()} y se mapea
	 * automático a {@link NinjaNinjutsuDto}
	 */
	@Test
	@Transactional
	void proyectionQueryTest() {

		String nombreNinja = "MaQuiNa1995";
		String nombreNinjutsu = "Puño Calamitoso";

		// Se crea el ninja
		Ninja ninja = new Ninja();
		ninja.setNombre(nombreNinja);

		// Se crea el ninjutsu
		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre(nombreNinjutsu);

		// Se setea el ninjutsu al ninja
		ninja.setNinjutsu(ninjutsu);

		// Se persiste en cascada los 2
		entityManager.persist(ninja);

		// Se crea la query llamando al constructor del Dto
		// {@link NinjaNinjutsuDto#NinjaNinjutsuDto(String, String)}
		NinjaNinjutsuDto ninjaNinjutsuDto = entityManager
				.createQuery("select new maquina.hibernate.dto.NinjaNinjutsuDto(ninja.nombre, ninja.ninjutsu.nombre)"
						+ "from Ninja ninja", NinjaNinjutsuDto.class)
				// en este caso sabemos que si o si solo va haber 1 resultado
				// por eso se usa el singleResult
				.getSingleResult();

		// Se comprueba
		Assertions.assertEquals(nombreNinja, ninjaNinjutsuDto.getNombreNinja());
		Assertions.assertEquals(nombreNinjutsu, ninjaNinjutsuDto.getNombreNinjutsu());

	}

}
