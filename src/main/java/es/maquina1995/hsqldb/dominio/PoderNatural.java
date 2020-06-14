package es.maquina1995.hsqldb.dominio;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 * 
 */
@Entity
@Table(name = "PODER_NATURAL")
@AttributeOverride(name = "id", column = @Column(name = "ID_PODER_NATURAL"))
public class PoderNatural extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 776100012000395211L;

}
