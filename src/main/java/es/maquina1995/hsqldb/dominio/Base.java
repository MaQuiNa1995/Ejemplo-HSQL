package es.maquina1995.hsqldb.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.Identificable;

@Entity
@Table(name = "BASE")
public class Base implements Identificable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBase;

    @Column(name = "cantidadMineral")
    private int cantidadMineral;

    @Column(name = "tipoMineral")
    private String tipoMineral;

    @Column(name = "TrabajadoresMaximo")
    private int TrabajadoresMaximo;

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trabajador trabajador;

    @Override
    public Long getId() {
	return idBase;
    }

    @Override
    public void setId(Long id) {
	this.idBase = id;
    }

    public int getCantidadMineral() {
	return cantidadMineral;
    }

    public void setCantidadMineral(int cantidadMineral) {
	this.cantidadMineral = cantidadMineral;
    }

    public String getTipoMineral() {
	return tipoMineral;
    }

    public void setTipoMineral(String tipoMineral) {
	this.tipoMineral = tipoMineral;
    }

    public int getTrabajadoresMaximo() {
	return TrabajadoresMaximo;
    }

    public void setTrabajadoresMaximo(int TrabajadoresMaximo) {
	this.TrabajadoresMaximo = TrabajadoresMaximo;
    }

    public Trabajador getTrabajador() {
	return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
	this.trabajador = trabajador;
    }

}
