package maquina.hibernate.dominio.one2many;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
        column = @Column(name = "ID_INVOCADOR"))
public class Invocador extends AbstractEntidadSimple<Long> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 4011086919749892365L;

	/**
	 * Esta al ser la parte dominante de la relacion debemos usar el
	 * {@link OneToMany} y el {@link JoinTable}
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
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "INVOCADORES_TIENEN_INVOCACIONES_SUPREMAS",
	        joinColumns = { @JoinColumn(name = "FK_INVOCADOR",
	                referencedColumnName = "ID_INVOCADOR") },
	        inverseJoinColumns = { @JoinColumn(name = "FK_INVOCACION_SUPREMA",
	                referencedColumnName = "ID_INVOCACION_SUPREMA") })
	private List<InvocacionSuprema> invocaciones;

}
