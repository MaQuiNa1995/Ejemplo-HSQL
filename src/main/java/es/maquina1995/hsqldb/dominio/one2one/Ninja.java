package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "NINJA")
public class Ninja implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381958348888873920L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_NINJA")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * En el name del {@link JoinColumn} se hace referencia al nombre del campo de
	 * la tabla de {@link Ninja} que tenga la foreign key de {@link Ninjutsu}
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_NINJUTSU")
	private Ninjutsu ninjutsu;

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

	public Ninjutsu getNinjutsu() {
		return ninjutsu;
	}

	public void setNinjutsu(Ninjutsu ninjutsu) {
		this.ninjutsu = ninjutsu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ninjutsu, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ninja other = (Ninja) obj;
		return Objects.equals(ninjutsu, other.ninjutsu) && Objects.equals(nombre, other.nombre);
	}

}
