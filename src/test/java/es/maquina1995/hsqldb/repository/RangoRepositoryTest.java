package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.Rango;
import es.maquina1995.hsqldb.dominio.Tecnica;

public class RangoRepositoryTest
		extends CrudRepositoryImplTest < Long, Rango >
{

	private RangoRepository cut;

	private Tecnica tecnica;

	@BeforeEach
	public void setUp ( )
	{

		this.tecnica = new Tecnica ( );
		this.tecnica.setNombre ( "Imitar" );

		getEntityManager ( ).persist ( this.tecnica );
	}

	@Override
	public CrudRepository < Long, Rango > getRepository ( )
	{
		return this.cut;
	}

	@Override
	public Rango getInstanceDeTParaNuevo ( )
	{
		Rango rango = new Rango ( );
		rango.setAlcanceMaximo ( 5 );

		rango.setTecnica ( this.tecnica );

		return rango;
	}

	@Override
	public Rango getInstanceDeTParaLectura ( )
	{
		Rango rango = new Rango ( );
		rango.setAlcanceMaximo ( 5 );

		rango.setTecnica ( this.tecnica );

		return rango;
	}

	@Override
	public boolean sonDatosIguales ( Rango rango1, Rango rango2 )
	{
		return rango1.equals ( rango2 );
	}

	@Override
	public Long getClavePrimariaNoExistente ( )
	{
		return Long.MAX_VALUE;
	}

	@Override
	public Rango getInstanceDeTParaModificar ( Long clave )
	{
		Rango rango = new Rango ( );
		rango.setAlcanceMaximo ( 5 );

		Tecnica tecnica = new Tecnica ( );
		tecnica.setNombre ( "Imitar" );

		rango.setTecnica ( tecnica );

		return rango;
	}

	@Autowired
	public void setRangoRepository ( RangoRepository sut )
	{
		this.cut = sut;
	}
}
