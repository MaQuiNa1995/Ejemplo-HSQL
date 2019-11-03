package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Rango;
import es.maquina1995.hsqldb.dominio.Tecnica;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class TecnicaRepositoryTest extends CrudRepositoryImplTest<Long, Tecnica> {

    private TecnicaRepository cut;
    private RangoRepository rangoRepository;

    @Override
    public CrudRepository<Long, Tecnica> getRepository() {
	return cut;
    }

    @Override
    public Tecnica getInstanceDeTParaNuevo() {
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Robar");
	
	Rango rango = new Rango();
	rango.setAlcanceMaximo(1);
	
	tecnica.setRango(rango);
	
	return tecnica;
    }

    @Override
    public Tecnica getInstanceDeTParaLectura() {
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Robar");
	
	Rango rango = new Rango();
	rango.setAlcanceMaximo(1);
	rangoRepository.persist(rango);
	
	tecnica.setRango(rango);
	
	return tecnica;
    }

    @Override
    public boolean sonDatosIguales(Tecnica magia1, Tecnica magia2) {
	return magia1.equals(magia2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Tecnica getInstanceDeTParaModificar(Long clave) {
	Tecnica tecnica = new Tecnica();
	tecnica.setNombre("Robar");
	
	Rango rango = new Rango();
	rango.setAlcanceMaximo(1);
	
	tecnica.setRango(rango);
	
	return tecnica;
    }

    @Autowired
    public void setMagiaRepository(TecnicaRepository sut) {
	this.cut = sut;
    }
    
    @Autowired
    public void setRangoRepository(RangoRepository rangoRepository) {
        this.rangoRepository = rangoRepository;
    }
}    
   