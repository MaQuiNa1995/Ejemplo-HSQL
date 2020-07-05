package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import jakarta.validation.constraints.NotNull;

/**
 * Clase base que tiene 2 atributos {@link AbstractEntidadSimple#getId()} y {@link AbstractEntidadSimple#getNombre()} extiende de esta para tener estos 2 atributos en tus entidades
 * 
 * @author MaQuiNa1995
 *
 * @param <K> representa la clave primaria de la entidad que extienda de esta clase {@link AbstractEntidadSimple}
 */
@MappedSuperclass
public abstract class AbstractEntidadSimple <K >
		extends Auditable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6609423905912801852L;

	/**
	 * Id de la entidad
	 * <p>
	 * Usamos un generador de secuencia para los id {@link GenerationType#SEQUENCE} en el caso de que tengamos debemos indicar en generator el nombr de nuestro generador de secuencias de base de datos
	 * <p>
	 * Como en este caso no tenemos definido ninguno nos creamos al vuelo uno propio que sea autoincremental con {@link SequenceGenerator}, podemos decirle el valor a incrementar cada vez a traves de allocationsize
	 * <p>
	 * Pongamos el ejemplo en el que allocationSize sea de 10
	 * <p>
	 * Si persisto una vez me inserta el id 1 pero la segunda me inserta la segunda entidad con el id 11 (1+10)
	 * 
	 */
	@Id
	@GeneratedValue ( generator = "sequence", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator ( name = "sequence", allocationSize = 10 )
	protected K id;

	@NotNull ( message = "El nombre no puede estar vacío, ni ser nulo ni solo tener espacios !!!" )
	@Column ( name = "NOMBRE", nullable = false )
	protected String nombre;

	public K getId ( )
	{
		return id;
	}

	public void setId ( K id )
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
		AbstractEntidadSimple < K > other = ( AbstractEntidadSimple < K > ) obj;
		return Objects.equals ( nombre, other.nombre );
	}

}
