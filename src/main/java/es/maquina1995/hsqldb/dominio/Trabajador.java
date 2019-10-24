package es.maquina1995.hsqldb.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.Identificable;

@Entity
@Table(name = "Trabajador")
public class Trabajador implements Identificable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;

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

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

}
