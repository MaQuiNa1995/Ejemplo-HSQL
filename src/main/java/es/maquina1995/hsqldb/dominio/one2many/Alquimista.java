package es.maquina1995.hsqldb.dominio.one2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "ALQUIMISTA")
public class Alquimista implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_ALQUIMISTA")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Aqui al ser la parte dominante de la relación el mappedBy se debe poner el
	 * objeto de {@link Pocion} que contiene la referencia a esta clase
	 * {@link Alquimista}
	 */
	@OneToMany(mappedBy = "alquimista", cascade = CascadeType.ALL)
	private List<Pocion> pociones;

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
