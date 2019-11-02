package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Rango;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class RangoRepositoryTest extends CrudRepositoryImplTest<Long, Rango> {

    private RangoRepository cut;

    @Override
    public CrudRepository<Long, Rango> getRepository() {
	return cut;
    }

    @Override
    public Rango getInstanceDeTParaNuevo() {
	Rango rango = new Rango();
	
	return rango;
    }

    @Override
    public Rango getInstanceDeTParaLectura() {
	Rango rango = new Rango();

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
	Rango trabajador = getInstanceDeTParaLectura();
	trabajador.setId(clave);
	return trabajador;
    }

    @Autowired
    public void setRangoRepository(RangoRepository sut) {
	this.cut = sut;
    }
}    
   