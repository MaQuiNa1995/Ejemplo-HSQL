package maquina.hibernate.dominio.one2many;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import maquina.hibernate.dominio.AbstractEntidadSimple;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AttributeOverride(name = "id",
        column = @Column(name = "ID_INVOCACION_SUPREMA"))
public class InvocacionSuprema extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6844034658579212079L;

	/**
	 * Parte Dominante
	 * <p>
	 * debemos usar el {@link ManyToOne} y el {@link JoinTable} y tambien debemos
	 * usar el (insertable = false y updatable = false) para evitar persistir la
	 * misma relacion en las 2 partes cuando estas propiedades están a false no se
	 * incluyen en las sql generadas de INSERT o Update
	 * 
	 * <li>INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS - hace referencia a la tabla
	 * intermedia que se genera</li>
	 * <li>FK_INVOCACION_SUPREMA - hace referencia al nombre de la columna que
	 * referencia a esta clase {@link InvocacionSuprema}</li>
	 * <li>ID_INVOCACION_SUPREMA - Hace referencia al nombre del id de esta clase
	 * {@link InvocacionSuprema}</li>
	 * <li>FK_INVOCADOR hace referencia al nombre de la columna que referencia a
	 * {@link Invocador} No hace falta ponerlo si referencias a la primary key</li>
	 * <li>ID_INVOCADOR - Hace referencia al nombre del id de {@link Invocador} No
	 * hace falta ponerlo si referencias a la primary key</li>
	 * <p>
	 * <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional-join-table.html">Mas
	 * Info</a>
	 * <p>
	 * Para convertirlo en unidireccional solo tienes que quitar la referencia al
	 * objeto dominante de la parte esclava es decir borrar el atributo personaje en
	 * este caso
	 */
	@ManyToOne(fetch = FetchType.LAZY,
	        cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS",
	        joinColumns = { @JoinColumn(name = "FK_INVOCACION_SUPREMA",
	                insertable = false,
	                updatable = false,
	                referencedColumnName = "ID_INVOCACION_SUPREMA") },
	        inverseJoinColumns = { @JoinColumn(name = "FK_INVOCADOR",
	                insertable = false,
	                updatable = false,
	                referencedColumnName = "ID_INVOCADOR") })
	private Invocador invocador;

}
