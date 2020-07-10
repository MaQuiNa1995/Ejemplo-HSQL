package maquina1995.hibernate.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import maquina1995.hibernate.repository.ElementalistaRepositoryImpl;

/**
 * Esta clase es la representacion de una entidad con una pk compuesta
 * {@link ElementalistaPk}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "ELEMENTALISTA")
@NamedQuery(name = ElementalistaRepositoryImpl.ELEMENTALISTA_FIND_ALL, query = "select elementalista from Elementalista elementalista")
public class Elementalista implements Persistible<ElementalistaPk> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5323271373231228172L;

	@EmbeddedId
	private ElementalistaPk id;

	@Column(name = "NOMBRE")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	@Override
	public ElementalistaPk getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(ElementalistaPk id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elementalista other = (Elementalista) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Elementalista [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
