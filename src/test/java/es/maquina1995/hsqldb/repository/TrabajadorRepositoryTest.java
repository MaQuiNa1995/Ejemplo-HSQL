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

    private TrabajadorRepository cut;

    @Override
    public CrudRepository<Long, Trabajador> getRepository() {
	return cut;
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
    public boolean sonDatosIguales(Trabajador trabajador1, Trabajador trabajador2) {
	return trabajador1.equals(trabajador2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Trabajador getInstanceDeTParaModificar(Long clave) {
	Trabajador trabajador = getInstanceDeTParaLectura().setTipoTrabajador("Zangano");
	// No se usa el id con la fluent api porque normalmente no tienes porque setear
	// la variable y asi está diseñado el dominio con esto en mente
	trabajador.setId(clave);
	
	return trabajador;
    }

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository sut) {
	this.cut = sut;
    }

}
