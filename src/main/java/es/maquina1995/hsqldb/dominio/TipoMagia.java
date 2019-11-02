package es.maquina1995.hsqldb.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.maquina1995.hsqldb.repository.Persistible;
import es.maquina1995.hsqldb.repository.TipoMagiaRepositoryImpl;

@Entity
@Table(name = TipoMagiaRepositoryImpl.TABLA)
public class TipoMagia implements Persistible<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Mago mago;

    @Override
    public Long getId() {
	return id;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public Mago getMago() {
        return mago;
    }

    public void setMago(Mago mago) {
        this.mago = mago;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

}
