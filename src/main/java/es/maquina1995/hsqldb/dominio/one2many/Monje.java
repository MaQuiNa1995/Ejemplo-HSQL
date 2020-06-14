package es.maquina1995.hsqldb.dominio.one2many;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "MONJE")
public class Monje implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_MONJE")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Como esta es la parte dominante de la relacion debemos en el name decirle el
	 * nombre de la columna de esta tabla que tiene referencia a esta clase
	 * {@link Monje} pero que se insertará como nueva columna en {@link TecnicaKi}
	 * de la misma forma en referencedColumnName debemos poner el campo ID de esta
	 * clase {@link Monje}
	 * 
	 */
	@OneToMany
	@JoinColumn(name = "FK_MONJE", referencedColumnName = "ID_MONJE")
	private List<TecnicaKi> tecnicas;

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
