package maquina.hibernate.dominio.many2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@AttributeOverride(name = "id", column = @Column(name = "ID_CALIDAD"))
public class Calidad extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8571421078317827105L;

	/**
	 * Al ser la parte de la relación esclava el mapeo la tiene la parte dominante
	 * en este caso {@link Arma} lo único que tienes que decir es que campo del
	 * objeto dominante tiene el mapeo de este objeto en este caso
	 * {@link Arma#getCalidades()}
	 * 
	 */
	@ManyToMany(mappedBy = "calidades")
	private List<Arma> armas;

	public List<Arma> getArmas() {
		return armas;
	}

	public void setArmas(List<Arma> armas) {
		this.armas = armas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(armas);
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
		Calidad other = (Calidad) obj;
		return Objects.equals(armas, other.armas);
	}

}
