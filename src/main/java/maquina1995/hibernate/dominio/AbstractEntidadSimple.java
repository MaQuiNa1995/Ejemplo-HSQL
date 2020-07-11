package maquina1995.hibernate.dominio;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import jakarta.validation.constraints.NotBlank;

/**
 * Clase base que tiene 3 atributos:
 * <li>{@link AbstractEntidadSimple#getId()}</li>
 * <li>{@link AbstractEntidadSimple#getNombre()}</li>
 * <li>{@link AbstractEntidadSimple#getReferencia()}</li>
 * <p>
 * Extiende de esta para tener estos 3 atributos en tus entidades
 * <p>
 * {@link NaturalIdCache} Se usa para crear una cache donde guardar una especie
 * de index de nuestros atributos anotados con {@link NaturalId}
 * <p>
 * En {@link Cache} le indicamos que estrategia usaremos para el guardado en
 * caché, en este caso: {@link CacheConcurrencyStrategy#READ_WRITE}
 * 
 * @author MaQuiNa1995
 *
 * @param <K> representa la clave primaria de la entidad que extienda de esta
 *            clase {@link AbstractEntidadSimple}
 */
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@MappedSuperclass
public abstract class AbstractEntidadSimple<K> extends AbstractAuditable {

	/**
	* 
	*/
	private static final long serialVersionUID = 7040921383481388954L;

	/**
	 * Id de la entidad
	 * <p>
	 * Usamos un generador de secuencia para los id {@link GenerationType#SEQUENCE}
	 * en el caso de que tengamos debemos indicar en generator el nombr de nuestro
	 * generador de secuencias de base de datos
	 * <p>
	 * Como en este caso no tenemos definido ninguno nos creamos al vuelo uno propio
	 * que sea autoincremental con {@link SequenceGenerator}, podemos decirle el
	 * valor a incrementar cada vez a traves de allocationsize
	 * <p>
	 * Pongamos el ejemplo en el que allocationSize sea de 10
	 * <p>
	 * Si persisto una vez me inserta el id 1 pero la segunda me inserta la segunda
	 * entidad con el id 11 (1+10)
	 * 
	 */
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", allocationSize = 10)
	protected K id;

	/**
	 * Campo anotado con {@link NaturalId} que será nuestro id natural de Base de
	 * datos , usamos {@link UUID} ya que es un objeto que genera una secuencia
	 * "pseudo-aleatoria" de 16 letras y numeros separados en grupos de 4 por
	 * guiones
	 * <p>
	 * por defecto siempre es: <code> mutable = false </code> asique en este caso no
	 * haría falta ponerlo
	 * <p>
	 * El tema de hacer este campo {@link NaturalId} es que cuando se persista la
	 * entidad se crea una entrada en cache y cuando se vaya a traer la entidad de
	 * base de datos a traves de este campo acudirá a caché en vez de a base de
	 * datos disminuyendo la carga de la BD
	 * <p>
	 * <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-naturalid-business-key-with-jpa-and-hibernate/">Mas
	 * Info Aquí</a>
	 */
	@NaturalId(mutable = false)
	@NotBlank(message = "El objeto debe tener siempre una referencia !!!")
	@Column(unique = true)
	private UUID referencia;

	@NotBlank(message = "El nombre no puede estar vacío, ni ser nulo ni solo tener espacios !!!")
	protected String nombre;

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UUID getReferencia() {
		return referencia;
	}

	@PrePersist
	private void createReferencia() {
		this.referencia = UUID.randomUUID();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntidadSimple<K> other = (AbstractEntidadSimple<K>) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
