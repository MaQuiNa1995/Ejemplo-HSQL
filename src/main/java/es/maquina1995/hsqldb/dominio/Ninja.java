package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table ( name = "NINJA" )
public class Ninja
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

	@Override
	public int hashCode ( )
	{
		return Objects.hash ( nombre );
	}

	@Override
	public boolean equals ( Object obj )
	{
		if ( this == obj ) return true;
		if ( obj == null ) return false;
		if ( getClass ( ) != obj.getClass ( ) ) return false;
		Ninja other = ( Ninja ) obj;
		return Objects.equals ( nombre, other.nombre );
	}

}
