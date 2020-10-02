package maquina.hibernate.dominio.one2many;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_ALQUIMISTA"))
public class Alquimista extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5371981248296997762L;

	/**
	 * Aqui al ser la parte esclava de la relación el mappedBy se debe poner el
	 * objeto de {@link Pocion} que contiene la referencia a esta clase
	 * {@link Alquimista}
	 */
	@OneToMany(mappedBy = "alquimista")
	private List<Pocion> pociones;

}
