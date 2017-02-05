package es.cic.curso.curso18.mascotastarcraft.Sitio;

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
public class Mapa implements Identificable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 8315207157111876609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMapa;

    @Column(name = "nombreMapa")
    private String nombreMapa;

    @Column(name = "basesMaximo")
    private int basesMaximo;
    
    @Column(name = "jugadoresMaximo")
    private int jugadoresMaximo;

    @JoinColumn(name = "idBase")
    @ManyToOne(fetch = FetchType.LAZY)
    private String idBase;

    public Mapa(String nombreMapa, int basesMaximo, String idBase) {
        this.nombreMapa = nombreMapa;
        this.basesMaximo = basesMaximo;
        this.idBase = idBase;
    }

    public Mapa() {
    }
    
    public String getNombreMapa() {
        return nombreMapa;
    }

    public void setNombreMapa(String nombreMapa) {
        this.nombreMapa = nombreMapa;
    }

    public int getBasesMaximo() {
        return basesMaximo;
    }

    public void setBasesMaximo(int basesMaximo) {
        this.basesMaximo = basesMaximo;
    }

    @Override
    public Long getId() {
        return this.idMapa;
    }

    @Override
    public void setId(Long idMapa) {
        this.idMapa=idMapa;
    }

    public int getJugadoresMaximo() {
        return jugadoresMaximo;
    }

    public void setJugadoresMaximo(int jugadoresMaximo) {
        this.jugadoresMaximo = jugadoresMaximo;
    }

    public String getIdBase() {
        return idBase;
    }

    public void setIdBase(String idBase) {
        this.idBase = idBase;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idMapa);
        hash = 19 * hash + Objects.hashCode(this.nombreMapa);
        hash = 19 * hash + this.basesMaximo;
        hash = 19 * hash + this.jugadoresMaximo;
        hash = 19 * hash + Objects.hashCode(this.idBase);
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
        final Mapa other = (Mapa) obj;
        if (this.basesMaximo != other.basesMaximo) {
            return false;
        }
        if (this.jugadoresMaximo != other.jugadoresMaximo) {
            return false;
        }
        if (!Objects.equals(this.nombreMapa, other.nombreMapa)) {
            return false;
        }
        if (!Objects.equals(this.idBase, other.idBase)) {
            return false;
        }
        if (!Objects.equals(this.idMapa, other.idMapa)) {
            return false;
        }
        return true;
    }

    
    

}
