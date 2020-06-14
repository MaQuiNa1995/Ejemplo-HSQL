package es.maquina1995.hsqldb.dominio.one2many;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "INVOCACION_SUPREMA")
public class InvocacionSuprema implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_INVOCACION_SUPREMA")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Esta al ser la parte esclava de la relación debemos usar el {@link ManyToOne}
	 * y tambien debemos usar el (insertable = false y updatable = false) para
	 * evitar persistir la misma relacion en las 2 partes cuando estas propiedades
	 * están a false no se incluyen en las sql generadas de INSERT o Update
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
	 * <p>
	 * Para convertirlo en unidireccional solo tienes que quitar la referencia al
	 * objeto dominante de la parte esclava es decir borrar el atributo personaje en
	 * este caso
	 */
	@ManyToOne
	@JoinTable(name = "INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS", joinColumns = {
			@JoinColumn(name = "FK_INVOCACION_SUPREMA", insertable = false, updatable = false, referencedColumnName = "ID_INVOCACION_SUPREMA") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_INVOCADOR", insertable = false, updatable = false, referencedColumnName = "ID_INVOCADOR") })
	private Invocador invocador;

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

	public Invocador getInvocador() {
		return invocador;
	}

	public void setInvocador(Invocador invocador) {
		this.invocador = invocador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invocador, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvocacionSuprema other = (InvocacionSuprema) obj;
		return Objects.equals(invocador, other.invocador) && Objects.equals(nombre, other.nombre);
	}

}
