package maquina.hibernate.dominio.many2many;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
        column = @Column(name = "ID_DOMADOR"))
public class Domador extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 736097050475158528L;

	/**
	 * Esta clase es la parte dominante de la relación
	 * <p>
	 * Usamos Set porque es mas eficiente , cuando se tratan con relaciones
	 * many2many con listas las operaciones que se hacen al eliminar eliminan la
	 * totalidad de los objetos y luego los vuelve a insertar
	 * <p>
	 * <a href=
	 * "https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/">mas
	 * info aqui</a>
	 * <p>
	 * <li>DOMADORES_TIENEN_BESTIAS - nombre de la tabla intermedia</li>
	 * <li>FK_DOMADOR - nombre de la columna de la tabla intermedia que hace
	 * referencia a este objeto {@link Domador}</li>
	 * <li>FK_BESTIA nombre de la columna de la tabla intermedia que referencia al
	 * objeto {@link Bestia}</li>
	 * 
	 * <li>ID_DOMADOR nombre de la columna id de la tabla {@link Domador}</li>
	 * <li>ID_BESTIA nombre de la columna id de la tabla {@link Bestia}</li>
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "DOMADORES_TIENEN_BESTIAS",
	        joinColumns = @JoinColumn(name = "FK_DOMADOR",
	                referencedColumnName = "ID_DOMADOR"),
	        inverseJoinColumns = @JoinColumn(name = "FK_BESTIA",
	                referencedColumnName = "ID_BESTIA"))
	private Set<Bestia> bestias;
}
