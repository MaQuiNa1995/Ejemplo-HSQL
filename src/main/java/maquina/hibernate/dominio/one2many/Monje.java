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
@AttributeOverride(name = "id",
        column = @Column(name = "ID_MONJE"))
public class Monje extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2382819739532578885L;

	/**
	 * Parte Dominante
	 * <p>
	 * name = columna en base de datos que hará referencia a {@link TecnicaKi}
	 * <p>
	 * referencedColumnName = campo en base de datos de la primary key de
	 * {@link TecnicaKi}
	 * <p>
	 * orphanRemoval = se debe establecer a true para que las entidades que pierdan
	 * la relación (es decir se queden huérfanas) puedan ser borradas
	 * automáticamente
	 */
	@OneToMany(cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JoinColumn(name = "FK_MONJE",
	        referencedColumnName = "ID_MONJE")
	private List<TecnicaKi> tecnicas;

}
