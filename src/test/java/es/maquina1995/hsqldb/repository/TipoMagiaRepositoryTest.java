package es.maquina1995.hsqldb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import es.maquina1995.hsqldb.dominio.one2one.Mago;
import es.maquina1995.hsqldb.dominio.one2one.TipoMagia;

public class TipoMagiaRepositoryTest
		extends CrudRepositoryImplTest < Long, TipoMagia >
{

	private TipoMagiaRepository cut;

	@Override
	public CrudRepository < Long, TipoMagia > getRepository ( )
	{
		return cut;
	}

	@Override
	public TipoMagia getInstanceDeTParaNuevo ( )
	{
		TipoMagia tipoMagia = new TipoMagia ( );
		tipoMagia.setNombre ( "Magia Roja" );

		Mago mago = new Mago ( );
		mago.setNombre ( "Mago Rojo" );

		tipoMagia.setMago ( mago );

		return tipoMagia;
	}

	@Override
	public TipoMagia getInstanceDeTParaLectura ( )
	{
		TipoMagia tipoMagia = new TipoMagia ( );
		tipoMagia.setNombre ( "Magia Roja" );

		Mago mago = new Mago ( );
		mago.setNombre ( "Mago Rojo" );

		tipoMagia.setMago ( mago );

		return tipoMagia;
	}

	@Override
	public boolean sonDatosIguales ( TipoMagia tipoMagia1, TipoMagia tipoMagia2 )
	{
		return tipoMagia1.equals ( tipoMagia2 );
	}

	@Override
	public Long getClavePrimariaNoExistente ( )
	{
		return Long.MAX_VALUE;
	}

	@Override
	public TipoMagia getInstanceDeTParaModificar ( Long clave )
	{
		TipoMagia tipoMagia = new TipoMagia ( );

		tipoMagia.setId ( clave );
		tipoMagia.setNombre ( "Magia Roja" );

		Mago mago = new Mago ( );
		mago.setId ( clave );
		mago.setNombre ( "Mago Rojo" );

		tipoMagia.setMago ( mago );

		return tipoMagia;
	}

	@Autowired
	public void setTipoMagiaRepository ( TipoMagiaRepository sut )
	{
		this.cut = sut;
	}
}
