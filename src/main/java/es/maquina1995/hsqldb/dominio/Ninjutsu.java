package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table ( name = "NINJUTSU" )
public class Ninjutsu
		implements Persistible < Long >
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( generator = "increment" )
	@GenericGenerator ( name = "increment", strategy = "increment" )
	private Long id;

	@Column ( name = "NOMBRE" )
	private String nombre;

	@OneToOne ( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn ( name = "id" )
	private Ninja ninja;

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

	public String getNombre ( )
	{
		return nombre;
	}

	public void setNombre ( String nombre )
	{
		this.nombre = nombre;
	}

	public Ninja getNinja ( )
	{
		return ninja;
	}

	public void setNinja ( Ninja ninja )
	{
		this.ninja = ninja;
	}

	@Override
	public int hashCode ( )
	{
		return Objects.hash ( ninja, nombre );
	}

	@Override
	public boolean equals ( Object obj )
	{
		if ( this == obj ) return true;
		if ( obj == null ) return false;
		if ( getClass ( ) != obj.getClass ( ) ) return false;
		Ninjutsu other = ( Ninjutsu ) obj;
		return Objects.equals ( ninja, other.ninja ) && Objects.equals ( nombre, other.nombre );
	}

}
