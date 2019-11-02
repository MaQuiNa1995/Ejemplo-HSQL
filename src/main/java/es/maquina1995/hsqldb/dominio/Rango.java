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

import es.maquina1995.hsqldb.repository.Persistible;

@Entity
@Table(name = "RANGO")
public class Rango implements Persistible<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RANGO")
    private int alcance;

    @OneToOne(mappedBy = "rango", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Magia magia;

    @Override
    public Long getId() {
	return id;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public Magia getMagia() {
        return magia;
    }

    public void setMagia(Magia magia) {
        this.magia = magia;
    }

    public int getAlcance() {
	return alcance;
    }

    public void setAlcances(int alcance) {
	this.alcance = alcance;
    }

}
