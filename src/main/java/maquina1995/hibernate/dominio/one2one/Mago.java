package maquina1995.hibernate.dominio.one2one;

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
@Table(name = "MAGO")
@AttributeOverride(name = "id", column = @Column(name = "ID_MAGO"))
public class Mago extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989113396933084418L;

	/**
	 * Como usamos en la parte esclava de la relacion el
	 * {@link javax.persistence.MapsId} nos aseguramos que el Id de {@link Mago}
	 * siempre está en {@link TipoMagia#getMago()}
	 * 
	 * <b>Mas info de esto:</b> <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/">Aquí</a>
	 * 
	 */

}
