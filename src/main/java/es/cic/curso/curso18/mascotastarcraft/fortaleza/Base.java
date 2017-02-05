package es.cic.curso.curso18.mascotastarcraft.fortaleza;

import es.cic.curso.curso18.mascotastarcraft.dominio.Identificable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Base implements Identificable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBase;

    @Column(name = "cantidadMineral")
    private int cantidadMineral;

    @Column(name = "tipoMineral")
    private String tipoMineral;

    @Column(name = "TrabajadoresMaximo")
    private String TrabajadoresMaximo;
    
    @JoinColumn(name = "idTrabajador")
    @ManyToOne(fetch = FetchType.LAZY)
    private String idTrabajador;

    public Base() {
    }

    public Base(int cantidadMineral, String tipoMineral, String TrabajadoresMaximo, String idTrabajador) {
        this.cantidadMineral = cantidadMineral;
        this.tipoMineral = tipoMineral;
        this.TrabajadoresMaximo = TrabajadoresMaximo;
        this.idTrabajador = idTrabajador;
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

    public String getTrabajadoresMaximo() {
        return TrabajadoresMaximo;
    }

    public void setTrabajadoresMaximo(String TrabajadoresMaximo) {
        this.TrabajadoresMaximo = TrabajadoresMaximo;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public Long getId() {
        return this.idBase;
    }

    @Override
    public void setId(Long idBase) {
        this.idBase = idBase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idBase);
        hash = 53 * hash + this.cantidadMineral;
        hash = 53 * hash + Objects.hashCode(this.tipoMineral);
        hash = 53 * hash + Objects.hashCode(this.TrabajadoresMaximo);
        hash = 53 * hash + Objects.hashCode(this.idTrabajador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Base other = (Base) obj;
        if (this.cantidadMineral != other.cantidadMineral) {
            return false;
        }
        if (!Objects.equals(this.tipoMineral, other.tipoMineral)) {
            return false;
        }
        if (!Objects.equals(this.TrabajadoresMaximo, other.TrabajadoresMaximo)) {
            return false;
        }
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        if (!Objects.equals(this.idBase, other.idBase)) {
            return false;
        }
        return true;
    }
    
}
