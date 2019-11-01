package es.maquina1995.hsqldb.dominio;

import java.util.List;
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
 * Entidad que tiene la información referente a las bases que tiene un Mapa
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "BASE")
public class Base implements Persistible<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    /**
     * Id de la tabla autogenerado {@link GenerationType#IDENTITY}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBase;

    /**
     * Cantidad de mineral que tiene la base al inicio
     */
    @Column(name = "cantidadMineral")
    private int cantidadMineral;

    /**
     * Tipo de mineral que tiene la base
     */
    @Column(name = "tipoMineral")
    private String tipoMineral;

    /**
     * Máximo de trabajadores que puede tener la base
     */
    @Column(name = "trabajadoresMaximo")
    private int trabajadoresMaximo;

    /**
     * Columna que referencia a los trabajadores que posee una base
     * <p>
     * <a href=
     * "https://stackoverflow.com/questions/199498/foreign-key-naming-scheme">Convención
     * de nombres FK_ForeignKeyTable_PrimaryKeyTable</a>
     */
    @JoinColumn(name = "FK_TRABAJADOR_IDTRABAJADOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private List<Trabajador>  listaTrabajadores;

    @Override
    public Long getId() {
	return idBase;
    }

    @Override
    public void setId(Long idBase) {
	this.idBase = idBase;
    }

    public int getCantidadMineral() {
	return cantidadMineral;
    }

    public Base setCantidadMineral(int cantidadMineral) {
	this.cantidadMineral = cantidadMineral;
	return this;
    }

    public String getTipoMineral() {
	return tipoMineral;
    }

    public Base setTipoMineral(String tipoMineral) {
	this.tipoMineral = tipoMineral;
	return this;
    }

    public int getTrabajadoresMaximo() {
	return trabajadoresMaximo;
    }

    public Base setTrabajadoresMaximo(int trabajadoresMaximo) {
	this.trabajadoresMaximo = trabajadoresMaximo;
	return this;
    }

    public List<Trabajador> getListaTrabajadores() {
	return listaTrabajadores;
    }

    public Base setListaTrabajadores(List<Trabajador> listaTrabajadores) {
	this.listaTrabajadores = listaTrabajadores;
	return this;
    }

    @Override
    public int hashCode() {
	return Objects.hash(cantidadMineral, tipoMineral, listaTrabajadores, trabajadoresMaximo);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Base other = (Base) obj;
	return cantidadMineral == other.cantidadMineral && Objects.equals(tipoMineral, other.tipoMineral)
		&& Objects.equals(listaTrabajadores, other.listaTrabajadores) && trabajadoresMaximo == other.trabajadoresMaximo;
    }

}
