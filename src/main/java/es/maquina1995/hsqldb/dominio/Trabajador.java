package es.maquina1995.hsqldb.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import es.maquina1995.hsqldb.repository.Persistible;
import es.maquina1995.hsqldb.repository.TrabajadorRepositoryImpl;

/**
 * Entidad que tiene la información referente a los trabajadores que tiene una
 * base
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "TRABAJADOR")
@NamedQuery(name = TrabajadorRepositoryImpl.FIND_TRABAJADORES_BY_PK, query = "SELECT tra FROM TRABAJADOR WHERE tra.idTrabajador IN :arrayId", comment = "Query para leer todos los nombres de los usuarios registrados")
public class Trabajador implements Persistible<Long> {

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

    @Override
    public int hashCode() {
	return Objects.hash(idTrabajador, tipoTrabajador);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Trabajador other = (Trabajador) obj;
	return Objects.equals(tipoTrabajador, other.tipoTrabajador);
    }

}
