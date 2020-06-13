package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "PERSONAJE")
public class Personaje implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6879662285510883545L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_PERSONAJE")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, oficio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(oficio, other.oficio);
	}

}
