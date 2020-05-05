package es.maquina1995.hsqldb.dominio;

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
	@JoinColumn ( name = "USER_ID" )
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

}
