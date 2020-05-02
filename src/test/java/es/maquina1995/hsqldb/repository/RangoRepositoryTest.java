package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.dominio.Rango;
import es.maquina1995.hsqldb.dominio.Tecnica;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class})
public class RangoRepositoryTest extends CrudRepositoryImplTest<Long, Rango> {

    private RangoRepository cut;

    @Override
    public CrudRepository<Long, Rango> getRepository() {
	return cut;
    }

    @Override
    public Rango getInstanceDeTParaNuevo() {
	Rango rango = new Rango();
	rango.setAlcanceMaximo(5);
	
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Imitar");
	
	rango.setTecnica(tecnica);
	
	return rango;
    }

    @Override
    public Rango getInstanceDeTParaLectura() {
	Rango rango = new Rango();
	rango.setAlcanceMaximo(5);
	
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Imitar");
	
	rango.setTecnica(tecnica);
	
	return rango;
    }

    @Override
    public boolean sonDatosIguales(Rango rango1, Rango rango2) {
	return rango1.equals(rango2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Rango getInstanceDeTParaModificar(Long clave) {
	Rango rango = new Rango();
	rango.setAlcanceMaximo(5);
	
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Imitar");
	
	rango.setTecnica(tecnica);
	
	return rango;
    }

    @Autowired
    public void setRangoRepository(RangoRepository sut) {
	this.cut = sut;
    }
}    
   