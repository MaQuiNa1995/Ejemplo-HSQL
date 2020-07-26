package maquina.hibernate.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import maquina.hibernate.repository.ElementalistaRepositoryImpl;

/**
 * Esta clase es la representacion de una entidad con una pk compuesta
 * {@link ElementalistaPk}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table
@NamedQuery(name = ElementalistaRepositoryImpl.ELEMENTALISTA_FIND_ALL, query = "select elementalista from Elementalista elementalista")
public class Elementalista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5440566391256042865L;

	@EmbeddedId
	private ElementalistaPk id;

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
	public ElementalistaPk getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
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

}
