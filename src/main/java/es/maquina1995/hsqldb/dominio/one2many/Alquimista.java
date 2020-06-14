package es.maquina1995.hsqldb.dominio.one2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "ALQUIMISTA")
@AttributeOverride(name = "id", column = @Column(name = "ID_ALQUIMISTA"))
public class Alquimista extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5371981248296997762L;

	/**
	 * Aqui al ser la parte dominante de la relación el mappedBy se debe poner el
	 * objeto de {@link Pocion} que contiene la referencia a esta clase
	 * {@link Alquimista}
	 */
	@OneToMany(mappedBy = "alquimista", cascade = CascadeType.ALL)
	private List<Pocion> pociones;

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, pociones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquimista other = (Alquimista) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pociones, other.pociones);
	}

}
