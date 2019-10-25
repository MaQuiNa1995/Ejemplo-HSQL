package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Trabajador;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class TrabajadorRepositoryTest extends CrudRepositoryImplTest<Long, Trabajador> {

    private TrabajadorRepository sut;

    @Override
    public CrudRepository<Long, Trabajador> getRepository() {
	return sut;
    }

    @Override
    public Trabajador getInstanceDeTParaNuevo() {
	Trabajador trabajadorTest = new Trabajador();
	trabajadorTest.setTipoTrabajador("Zangano");
	return trabajadorTest;
    }

    @Override
    public Trabajador getInstanceDeTParaLectura() {
	Trabajador trabajadorTest = new Trabajador();
	trabajadorTest.setTipoTrabajador("Zangano");
	return trabajadorTest;
    }

    @Override
    public boolean sonDatosIguales(Trabajador t1, Trabajador t2) {
	if (t1 == null || t2 == null) {
	    throw new UnsupportedOperationException("No puedo comparar nulos");
	}

	if (!t1.getTipoTrabajador().equals(t2.getTipoTrabajador())) {
	    return false;
	}

	return true;
    }

    @Override
    public Long getClavePrimariaNoExistente() {

	return Long.MAX_VALUE;

    }

    @Override
    public Trabajador getInstanceDeTParaModificar(Long clave) {
	Trabajador trabajador = getInstanceDeTParaLectura();
	trabajador.setId(clave);
	trabajador.setTipoTrabajador("Zangano");
	return trabajador;
    }

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository sut) {
	this.sut = sut;
    }

}
