package maquina.hibernate.dominio.one2one;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
@AttributeOverride(name = "id",
        column = @Column(name = "ID_TIPO_MAGIA"))
public class TipoMagia extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4363034868100782711L;

	/**
	 * {@link MapsId} Lo que hace es crear una columna nueva en esta clase
	 * {@link TipoMagia} que tenga el mismo id que la del objeto que hace referencia
	 * en este caso {@link Mago}
	 * <p>
	 * De tal manera que se convierte en una "bidireccional" porque desde esta
	 * entidad que en este caso es la esclava tenemos el Id de la dominante
	 * {@link Mago}
	 * <p>
	 * Por defecto es {@link FetchType#EAGER}
	 * <p>
	 * <b>Mas info de esto:</b> <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/">Aquí</a>
	 */
	@MapsId
	@OneToOne(fetch = FetchType.LAZY,
	        cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_MAGO")
	private Mago mago;
}
