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

import es.maquina1995.hsqldb.repository.MagoRepositoryImpl;
import es.maquina1995.hsqldb.repository.Persistible;

@Entity
@Table(name = MagoRepositoryImpl.TABLA)
public class Mago implements Persistible<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToOne(mappedBy = "mago", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private TipoMagia tipoMagia;

    @Override
    public Long getId() {
	return id;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public TipoMagia getTipoMagia() {
	return tipoMagia;
    }

    public void setTipoMagia(TipoMagia tipoMagia) {
	this.tipoMagia = tipoMagia;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

}
