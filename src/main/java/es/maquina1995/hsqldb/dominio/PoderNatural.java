package es.maquina1995.hsqldb.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table ( name = "PODER_NATURAL" )
public class PoderNatural
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

}
