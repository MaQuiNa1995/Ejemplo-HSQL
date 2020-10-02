package maquina.hibernate.dominio.one2one;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import maquina.hibernate.dominio.AbstractEntidadSimple;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AttributeOverride(name = "id", column = @Column(name = "ID_RANGO"))
public class Rango extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8164571656516905569L;

	/**
	 * Aqui al ser la parte dominante de la relación en el {@link JoinColumn} se
	 * hace referencia al nombre de la columna de esta clase {@link Rango} que
	 * contiene la foreign key de {@link Tecnica}
	 * <p>
	 * <b>Mas info de esto:</b> <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-one-bidirectional.html">Aquí</a>
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_TECNICA")
	private Tecnica tecnica;

}
