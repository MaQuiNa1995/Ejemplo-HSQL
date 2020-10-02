package maquina.hibernate.dominio.one2many;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@AttributeOverride(name = "id", column = @Column(name = "ID_POCION"))
public class Pocion extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1201699757021907081L;

	/**
	 * Aqui al ser la parte domninante se debe usar el {@link ManyToOne} y en el
	 * {@link JoinColumn}
	 * <p>
	 * Se debe poner el nombre de la columna que haga referencia a la parte
	 * dominante de la relacion {@link Alquimista}
	 * <p>
	 * Si quieres que este campo no sea nullable es preferible usar {@link NotNull}
	 * antes que <code>nullable = false</code> de {@link JoinColumn} ya que esta
	 * última lo valida despues de hacer la query , la primera valida antes de
	 * hacerla
	 * <p>
	 * Solo debemos usar el {@link CascadeType#MERGE} y el
	 * {@link CascadeType#PERSIST} porque estamos en la misma tesitura que en las
	 * {@link ManyToMany}
	 * <p>
	 * En este caso si tenemos el {@link CascadeType#REMOVE} de la que eliminemos 1
	 * {@link Pocion} tambien eliminaremos el {@link Alquimista} por lo tanto si
	 * este tiene mas de 1 {@link Pocion} las dejaremos huérfanas y habremos roto la
	 * integridad de la base de datos
	 * 
	 * <a href="https://www.baeldung.com/hibernate-notnull-vs-nullable">Más info
	 * sobre el notnull vs nullable aquí</a>
	 * 
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "FK_ALQUIMISTA")
	private Alquimista alquimista;

}
