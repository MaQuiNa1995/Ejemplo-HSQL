package es.maquina1995.hsqldb.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.Identificable;

/**
 * Entidad que tiene la información referente a los trabajadores que tiene una
 * base
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "TRABAJADOR")
public class Trabajador implements Identificable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    /**
     * Id de la tabla autogenerado {@link GenerationType#IDENTITY}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;

    /**
     * Tipo de trabajador
     */
    @Column(name = "tipoTrabajador")
    private String tipoTrabajador;

    @Override
    public Long getId() {
	return this.idTrabajador;
    }

    @Override
    public void setId(Long idTrabajador) {
	this.idTrabajador = idTrabajador;
    }

    public String getTipoTrabajador() {
	return tipoTrabajador;
    }

    public Trabajador setTipoTrabajador(String tipoTrabajador) {
	this.tipoTrabajador = tipoTrabajador;
	return this;
    }

}
