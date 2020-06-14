package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.dominio.AbstractEntidadSimple;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "TIPO_MAGIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_TIPO_MAGIA"))
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
	 * * <b>Mas info de esto:</b> <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/">Aquí</a>
	 */
	@MapsId
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_MAGO")
	private Mago mago;

	public Mago getMago() {
		return mago;
	}

	public void setMago(Mago mago) {
		this.mago = mago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mago);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMagia other = (TipoMagia) obj;
		return Objects.equals(mago, other.mago);
	}

}
