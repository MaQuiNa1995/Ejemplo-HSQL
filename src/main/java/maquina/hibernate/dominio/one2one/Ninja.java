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
@AttributeOverride(name = "id", column = @Column(name = "ID_NINJA"))
public class Ninja extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381958348888873920L;

	/**
	 * Al ser la parte dominante de la relación debemos usar {@link OneToOne} y
	 * {@link JoinColumn}
	 * <p>
	 * Se hace referencia al campo del objeto de {@link Ninja} que va a tener la
	 * relacion con {@link Ninjutsu} en base de datos se creará una columna con el
	 * nombre que le digamos en el name
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_NINJUTSU")
	private Ninjutsu ninjutsu;

}
