package maquina1995.hibernate.dominio.one2one;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "PERSONAJE")
@AttributeOverride(name = "id", column = @Column(name = "ID_PERSONAJE"))
public class Personaje extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2456995784254405473L;

	/**
	 * 
	 * <li>PERSONAJE_TIENE_OFICIO - Nombre de la tabla intermedia</li>
	 * <p>
	 * <li>FK_PERSONAJE - Nombre de la columna que tiene la tabla
	 * <b>PERSONAJE_TIENE_OFICIO</b> con la clave foránea de oficio</li>
	 * <li>ID_PERSONAJE - Nombre de la columna "Id" de {@link Personaje} que tendrá
	 * la tabla intermedia</li>
	 * <p>
	 * <li>FK_OFICIO - Nombre de la columna que tiene la tabla
	 * <b>PERSONAJE_TIENE_OFICIO</b> con la clave foránea de personaje</li>
	 * <li>ID_OFICIO - Nombre de la columna "Id" de {@link Oficio} que tendrá la
	 * tabla intermedia</li>
	 * <p>
	 * <b>Mas info de esto:</b> <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-one-join-table.html">Aquí</a>
	 * 
	 */

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PERSONAJE_TIENE_OFICIO", joinColumns = {
			@JoinColumn(name = "FK_PERSONAJE", referencedColumnName = "ID_PERSONAJE") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_OFICIO", referencedColumnName = "ID_OFICIO", unique = true) })
	private Oficio oficio;

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(oficio);
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
		Personaje other = (Personaje) obj;
		return Objects.equals(oficio, other.oficio);
	}

}
