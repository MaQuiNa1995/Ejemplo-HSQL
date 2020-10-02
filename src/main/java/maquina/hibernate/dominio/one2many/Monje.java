package maquina.hibernate.dominio.one2many;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_MONJE"))
public class Monje extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2382819739532578885L;

	/**
	 * Como esta es la parte dominante de la relacion debemos en el name decirle el
	 * nombre de la columna de esta tabla que tiene referencia a esta clase
	 * {@link Monje} pero que se insertará como nueva columna en {@link TecnicaKi}
	 * de la misma forma en referencedColumnName debemos poner el campo ID de esta
	 * clase {@link Monje}
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_MONJE", referencedColumnName = "ID_MONJE")
	private List<TecnicaKi> tecnicas;

}
