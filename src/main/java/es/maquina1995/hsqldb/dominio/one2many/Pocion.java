package es.maquina1995.hsqldb.dominio.one2many;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.dominio.AbstractEntidadSimple;
import jakarta.validation.constraints.NotNull;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "POCION")
@AttributeOverride(name = "id", column = @Column(name = "ID_POCION"))
public class Pocion extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1201699757021907081L;

	/**
	 * Aqui al ser la parte esclava se debe usar el {@link ManyToOne} y en el
	 * joinColumn se debe poner el nombre de la comlumna que haga referencia a la
	 * parte dominante de la relacion {@link Alquimista}
	 * <p>
	 * Es preferible usar {@link NotNull} antes que <code>nullable = false</code> de
	 * {@link JoinColumn} ya que esta última lo valida despues de hacer la query ,
	 * la primera valida antes de hacerla
	 * <p>
	 * <a href="https://www.baeldung.com/hibernate-notnull-vs-nullable">Más info
	 * aquí</a>
	 * 
	 */
	@ManyToOne
	@NotNull(message = "El alquimista debe estar informado !!")
	@JoinColumn(name = "FK_ALQUIMISTA")
	private Alquimista alquimista;

	public Alquimista getAlquimista() {
		return alquimista;
	}

	public void setAlquimista(Alquimista alquimista) {
		this.alquimista = alquimista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alquimista, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pocion other = (Pocion) obj;
		return Objects.equals(alquimista, other.alquimista) && Objects.equals(nombre, other.nombre);
	}

}
