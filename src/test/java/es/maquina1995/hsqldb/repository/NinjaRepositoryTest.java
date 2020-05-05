package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.Ninja;

public class NinjaRepositoryTest
		extends CrudRepositoryImplTest < Long, Ninja >
{

	private NinjaRepository cut;

	@Override
	public CrudRepository < Long, Ninja > getRepository ( )
	{
		return cut;
	}

	@Override
	public Ninja getInstanceDeTParaNuevo ( )
	{
		Ninja ninja = new Ninja ( );
		ninja.setNombre ( "Ninja Sepulcrador" );

		return ninja;
	}

	@Override
	public Ninja getInstanceDeTParaLectura ( )
	{
		Ninja ninja = new Ninja ( );
		ninja.setNombre ( "Ninja Sepulcrador" );
		return ninja;
	}

	@Override
	public boolean sonDatosIguales ( Ninja ninja1, Ninja ninja2 )
	{
		return ninja1.equals ( ninja2 );
	}

	@Override
	public Long getClavePrimariaNoExistente ( )
	{
		return Long.MAX_VALUE;
	}

	@Override
	public Ninja getInstanceDeTParaModificar ( Long clave )
	{
		Ninja ninja = getInstanceDeTParaLectura ( );
		ninja.setId ( clave );
		ninja.setNombre ( "Ninja Sepulcrador" );

		return ninja;
	}

	@Autowired
	public void setNinjaRepository ( NinjaRepository cut )
	{
		this.cut = cut;
	}
}
