package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;
import es.maquina1995.hsqldb.repository.TipoMagiaRepositoryImpl;

@Entity
@Table(name = TipoMagiaRepositoryImpl.TABLA)
public class TipoMagia implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9203098255394013528L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID_TIPO_MAGIA")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * {@link MapsId} Lo que hace es crear una columna nueva en esta clase
	 * {@link TipoMagia} que tenga el mismo id que la del objeto que hace referencia
	 * en este caso {@link Mago}
	 * <p>
	 * De tal manera que se convierte en una "bidireccional" porque desde esta
	 * entidad que en este caso es la esclava tenemos el Id de la dominante
	 * {@link Mago}
	 * <p>
	 * * <b>Mas info de esto:</b> <a href=
	 * "https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/">Aquí</a>
	 */
	@MapsId
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_MAGO")
	private Mago mago;

	public Mago getMago() {
		return mago;
	}

	public void setMago(Mago mago) {
		this.mago = mago;
	}

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
		return Objects.hash(mago, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMagia other = (TipoMagia) obj;
		return Objects.equals(mago, other.mago) && Objects.equals(nombre, other.nombre);
	}

}
