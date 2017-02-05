package es.cic.curso.curso18.mascotastarcraft.Sitio;

import es.cic.curso.curso18.mascotastarcraft.dominio.Identificable;
import es.cic.curso.curso18.mascotastarcraft.fortaleza.Base;
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
    private Base base;

    public Mapa(String nombreMapa, int basesMaximo, int jugadoresMaximo, Base base) {
        this.nombreMapa = nombreMapa;
        this.basesMaximo = basesMaximo;
        this.jugadoresMaximo = jugadoresMaximo;
        this.base = base;
    }

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

    public void setNombreMapa(String nombreMapa) {
        this.nombreMapa = nombreMapa;
    }

    public int getBasesMaximo() {
        return basesMaximo;
    }

    public void setBasesMaximo(int basesMaximo) {
        this.basesMaximo = basesMaximo;
    }

    public int getJugadoresMaximo() {
        return jugadoresMaximo;
    }

    public void setJugadoresMaximo(int jugadoresMaximo) {
        this.jugadoresMaximo = jugadoresMaximo;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    
}
