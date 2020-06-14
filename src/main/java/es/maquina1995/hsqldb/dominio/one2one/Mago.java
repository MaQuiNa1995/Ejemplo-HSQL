package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "MAGO")
public class Mago implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4144896102088412086L;

	/**
	 * Como usamos en la parte esclava de la relacion el
	 * {@link javax.persistence.MapsId} nos aseguramos que el Id de {@link Mago}
	 * siempre está en {@link TipoMagia#getMago()}
	 * 
	 * <b>Mas info de esto:</b> <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/">Aquí</a>
	 * 
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID_MAGO")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

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
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mago other = (Mago) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
