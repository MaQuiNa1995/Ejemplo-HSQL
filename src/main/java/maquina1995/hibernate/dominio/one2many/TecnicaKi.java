package maquina1995.hibernate.dominio.one2many;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import maquina1995.hibernate.dominio.AbstractEntidadSimple;

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
@AttributeOverride(name = "id", column = @Column(name = "ID_TECNICA_KI"))
public class TecnicaKi extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6697583198466623426L;

}
