package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Magia;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class MagiaRepositoryTest extends CrudRepositoryImplTest<Long, Magia> {

    private MagiaRepository cut;

    @Override
    public CrudRepository<Long, Magia> getRepository() {
	return cut;
    }

    @Override
    public Magia getInstanceDeTParaNuevo() {
	Magia magia = new Magia();
	
	return magia;
    }

    @Override
    public Magia getInstanceDeTParaLectura() {
	Magia magia = new Magia();

	return magia;
    }

    @Override
    public boolean sonDatosIguales(Magia magia1, Magia magia2) {
	return magia1.equals(magia2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Magia getInstanceDeTParaModificar(Long clave) {
	Magia trabajador = getInstanceDeTParaLectura();
	trabajador.setId(clave);
	return trabajador;
    }

    @Autowired
    public void setMagiaRepository(MagiaRepository sut) {
	this.cut = sut;
    }
}    
   