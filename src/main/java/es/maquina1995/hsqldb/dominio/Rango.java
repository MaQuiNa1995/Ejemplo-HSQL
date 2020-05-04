package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.repository.RangoRepositoryImpl;

@Entity
@Table ( name = RangoRepositoryImpl.TABLA )
public class Rango
		implements Persistible < Long >
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( generator = "increment" )
	@GenericGenerator ( name = "increment", strategy = "increment" )
	@Column ( name = "ID_RANGO" )
	private Long id;

	@Column ( name = "ALCANCE" )
	private int alcanceMaximo;

	@OneToOne
	@JoinColumn ( name = "tecnica" )
	private Tecnica tecnica;

	@Override
	public Long getId ( )
	{
		return id;
	}

	@Override
	public void setId ( Long id )
	{
		this.id = id;
	}

	public Tecnica getTecnica ( )
	{
		return tecnica;
	}

	public void setTecnica ( Tecnica tecnica )
	{
		this.tecnica = tecnica;
	}

	public int getAlcanceMaximo ( )
	{
		return alcanceMaximo;
	}

	public void setAlcanceMaximo ( int alcanceMaximo )
	{
		this.alcanceMaximo = alcanceMaximo;
	}

	@Override
	public int hashCode ( )
	{
		return Objects.hash ( alcanceMaximo, tecnica );
	}

	@Override
	public boolean equals ( Object obj )
	{
		if ( this == obj ) return true;
		if ( obj == null ) return false;
		if ( getClass ( ) != obj.getClass ( ) ) return false;
		Rango other = ( Rango ) obj;
		return alcanceMaximo == other.alcanceMaximo && Objects.equals ( tecnica, other.tecnica );
	}

}
