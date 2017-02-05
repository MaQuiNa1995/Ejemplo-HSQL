package es.cic.curso.curso18.mascotastarcraft.fortaleza;

import es.cic.curso.curso18.mascotastarcraft.dominio.Identificable;
import es.cic.curso.curso18.mascotastarcraft.obrero.Trabajador;
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
    private int TrabajadoresMaximo;
    
    @JoinColumn(name = "idTrabajador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trabajador trabajador;

    public Base() {
    }

    public Base(int cantidadMineral, String tipoMineral, int TrabajadoresMaximo, Trabajador trabajador) {
        this.cantidadMineral = cantidadMineral;
        this.tipoMineral = tipoMineral;
        this.TrabajadoresMaximo = TrabajadoresMaximo;
        this.trabajador = trabajador;
    }

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
