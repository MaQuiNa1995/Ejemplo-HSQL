package maquina.hibernate.dominio.many2many;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_CALIDAD"))
public class Calidad extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8571421078317827105L;

	/**
	 * Al ser la parte de la relación esclava el mapeo la tiene la parte dominante
	 * <p>
	 * En este caso {@link Arma} lo único que tienes que decir es que campo del
	 * objeto dominante tiene el mapeo de este objeto en este caso
	 * {@link Arma#getCalidades()}
	 * 
	 */
	@ManyToMany(mappedBy = "calidades")
	private List<Arma> armas;

}
