package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.Persistible;

/**
 * Entidad que tiene la información referente a los Mapas
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "MAPA")
public class Mapa implements Persistible<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    /**
     * Id de la tabla autogenerado {@link GenerationType#IDENTITY}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMapa;

    @Column(name = "nombreMapa")
    private String nombreMapa;

    @Column(name = "basesMaximo")
    private int basesMaximo;

    @Column(name = "jugadoresMaximo")
    private int jugadoresMaximo;

    @Column(name = "jugado")
    private boolean jugado;

    /**
     * Columna que referencia a las bases que posee un mapa
     * <p>
     * <a href=
     * "https://stackoverflow.com/questions/199498/foreign-key-naming-scheme">Convención
     * de nombres FK_ForeignKeyTable_PrimaryKeyTable</a>
     */
    @JoinColumn(name = "FK_BASE_IDBASE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Base base;

    @Override
    public Long getId() {
	return idMapa;
    }

    @Override
    public void setId(Long idMapa) {
	this.idMapa = idMapa;
    }

    public String getNombreMapa() {
	return nombreMapa;
    }

    public Mapa setNombreMapa(String nombreMapa) {
	this.nombreMapa = nombreMapa;
	return this;
    }

    public int getBasesMaximo() {
	return basesMaximo;
    }

    public Mapa setBasesMaximo(int basesMaximo) {
	this.basesMaximo = basesMaximo;
	return this;
    }

    public int getJugadoresMaximo() {
	return jugadoresMaximo;
    }

    public Mapa setJugadoresMaximo(int jugadoresMaximo) {
	this.jugadoresMaximo = jugadoresMaximo;
	return this;
    }

    public Base getBase() {
	return base;
    }

    public Mapa setBase(Base base) {
	this.base = base;
	return this;
    }

    public boolean isJugado() {
	return jugado;
    }

    public Mapa setJugado(boolean jugado) {
	this.jugado = jugado;
	return this;
    }

    @Override
    public int hashCode() {
	return Objects.hash(base, basesMaximo, idMapa, jugado, jugadoresMaximo, nombreMapa);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Mapa other = (Mapa) obj;
	return Objects.equals(base, other.base) && basesMaximo == other.basesMaximo && jugado == other.jugado
		&& jugadoresMaximo == other.jugadoresMaximo && Objects.equals(nombreMapa, other.nombreMapa);
    }

}
