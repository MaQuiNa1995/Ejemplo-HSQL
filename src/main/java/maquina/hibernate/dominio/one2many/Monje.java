package maquina.hibernate.dominio.one2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_MONJE"))
public class Monje extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2382819739532578885L;

	/**
	 * Como esta es la parte dominante de la relacion debemos en el name decirle el
	 * nombre de la columna de esta tabla que tiene referencia a esta clase
	 * {@link Monje} pero que se insertará como nueva columna en {@link TecnicaKi}
	 * de la misma forma en referencedColumnName debemos poner el campo ID de esta
	 * clase {@link Monje}
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_MONJE", referencedColumnName = "ID_MONJE")
	private List<TecnicaKi> tecnicas;

	public List<TecnicaKi> getTecnicas() {
		return tecnicas;
	}

	public void setTecnicas(List<TecnicaKi> tecnicas) {
		this.tecnicas = tecnicas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tecnicas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monje other = (Monje) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(tecnicas, other.tecnicas);
	}

}
