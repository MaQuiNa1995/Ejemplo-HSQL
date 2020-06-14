package es.maquina1995.hsqldb.dominio.one2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "ARMA")
public class Invocador implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_INVOCADOR")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Esta al ser la parte dominante de la relacion debemos usar el
	 * {@link OneToMany}
	 * 
	 * <li>INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS - hace referencia a la tabla
	 * intermedia que se genera</li>
	 * <li>FK_INVOCACION_SUPREMA - hace referencia al nombre de la columna que
	 * referencia a esta clase {@link InvocacionSuprema}</li>
	 * <li>ID_INVOCACION_SUPREMA - Hace referencia al nombre del id de esta clase
	 * {@link InvocacionSuprema}</li>
	 * <li>FK_INVOCADORhace referencia al nombre de la columna que referencia a
	 * {@link Invocador}</li>
	 * <li>ID_INVOCADOR - Hace referencia al nombre del id de {@link Invocador}</li>
	 * <p>
	 * <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional-join-table.html">Mas
	 * Info</a>
	 * 
	 * 
	 */
	@OneToMany
	@JoinTable(name = "INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS", joinColumns = {
			@JoinColumn(name = "FK_INVOCADOR", referencedColumnName = "ID_INVOCADOR") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_INVOCACION_SUPREMA", referencedColumnName = "ID_INVOCACION_SUPREMA") })
	private List<InvocacionSuprema> invocaciones;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invocaciones, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invocador other = (Invocador) obj;
		return Objects.equals(invocaciones, other.invocaciones) && Objects.equals(nombre, other.nombre);
	}

}
