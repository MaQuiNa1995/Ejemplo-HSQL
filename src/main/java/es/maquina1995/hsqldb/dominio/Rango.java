package es.maquina1995.hsqldb.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.RangoRepositoryImpl;

@Entity
@Table(name = RangoRepositoryImpl.TABLA)
public class Rango implements Persistible<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ALCANCE")
    private int alcanceMaximo;

    @OneToOne(mappedBy = "rango", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Tecnica tecnica;

    @Override
    public Long getId() {
	return id;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public int getAlcanceMaximo() {
	return alcanceMaximo;
    }

    public void setAlcanceMaximo(int alcanceMaximo) {
	this.alcanceMaximo = alcanceMaximo;
    }

}
