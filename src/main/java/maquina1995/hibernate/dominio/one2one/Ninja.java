package maquina1995.hibernate.dominio.one2one;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "NINJA")
@AttributeOverride(name = "id", column = @Column(name = "ID_NINJA"))
public class Ninja extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381958348888873920L;

	/**
	 * En el name del {@link JoinColumn} se hace referencia al nombre del campo de
	 * la tabla de {@link Ninja} que tenga la foreign key de {@link Ninjutsu}
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_NINJUTSU")
	private Ninjutsu ninjutsu;

	public Ninjutsu getNinjutsu() {
		return ninjutsu;
	}

	public void setNinjutsu(Ninjutsu ninjutsu) {
		this.ninjutsu = ninjutsu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ninjutsu);
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
		Ninja other = (Ninja) obj;
		return Objects.equals(ninjutsu, other.ninjutsu);
	}

}
