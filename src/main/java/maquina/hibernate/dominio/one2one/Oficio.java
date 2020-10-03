package maquina.hibernate.dominio.one2one;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
        column = @Column(name = "ID_OFICIO"))
public class Oficio extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4465939889127597689L;

	/**
	 * Debemos usar el (insertable = false y updatable = false) para evitar
	 * persistir la misma relacion en las 2 partes cuando estas propiedades están a
	 * false no se incluyen en las sql generadas de INSERT o Update
	 * 
	 * <li>PERSONAJE_TIENE_OFICIO - Nombre de la tabla intermedia</li>
	 * <p>
	 * <li>FK_PERSONAJE - Nombre de la columna que tiene la tabla
	 * <b>PERSONAJE_TIENE_OFICIO</b> con la clave foránea de oficio</li>
	 * <li>ID_PERSONAJE - Nombre de la columna "Id" de {@link Personaje} que tendrá
	 * la tabla intermedia</li>
	 * <p>
	 * <li>FK_OFICIO - Nombre de la columna que tiene la tabla
	 * <b>PERSONAJE_TIENE_OFICIO</b> con la clave foránea de personaje</li>
	 * <li>ID_OFICIO - Nombre de la columna "Id" de {@link Oficio} que tendrá la
	 * tabla intermedia</li>
	 * <p>
	 * <b>Mas info de esto:</b> <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-one-join-table.html">Aquí</a>
	 * <p>
	 * Para convertirlo en unidireccional solo tienes que quitar la referencia al
	 * objeto dominante de la parte esclava es decir borrar el atributo personaje en
	 * este caso
	 */
	@OneToOne(fetch = FetchType.LAZY,
	        cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PERSONAJE_TIENE_OFICIO",
	        joinColumns = { @JoinColumn(name = "FK_OFICIO",
	                insertable = false,
	                updatable = false,
	                referencedColumnName = "ID_OFICIO") },
	        inverseJoinColumns = { @JoinColumn(name = "FK_PERSONAJE",
	                insertable = false,
	                updatable = false,
	                referencedColumnName = "ID_PERSONAJE",
	                unique = true) })
	private Personaje personaje;

}
