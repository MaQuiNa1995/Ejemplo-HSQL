package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;
import es.maquina1995.hsqldb.repository.TecnicaRepositoryImpl;

@Entity
@Table(name = TecnicaRepositoryImpl.TABLA)
public class Tecnica implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 598701036486782764L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID_TECNICA")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Al ser {@link Tecnica} la parte dominante de la relacion en el mappedBy se
	 * hace referencia al nombre del objeto de {@link Rango} que hace referencia a
	 * esta clase {@link Tecnica}
	 * 
	 * <b>Mas info de esto:</b> <a href=
	 * "https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-one-bidirectional.html">Aquí</a>
	 * 
	 */
	@OneToOne(mappedBy = "tecnica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Rango rango;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, rango);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnica other = (Tecnica) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(rango, other.rango);
	}

}
