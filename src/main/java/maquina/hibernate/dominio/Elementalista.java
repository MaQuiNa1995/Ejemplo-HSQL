package maquina.hibernate.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@EqualsAndHashCode
@NamedQuery(name = ElementalistaRepositoryImpl.ELEMENTALISTA_FIND_ALL, query = "select elementalista from Elementalista elementalista")
public class Elementalista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5440566391256042865L;

	@EmbeddedId
	private ElementalistaPk id;
	private String nombre;

}
