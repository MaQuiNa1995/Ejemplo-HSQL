package es.maquina1995.hsqldb.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.IRepository;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class TrabajadorRepositoryTest extends AbstractRepositoryImplTest<Long, Trabajador> {


    private TrabajadorRepository sut;
    
	@Autowired
	public void setTrabajadorRepository(TrabajadorRepository sut) {
		this.sut = sut;
	}
    
    @Before
    @Override
    public void setUp() {
        super.setUp();
    }

    @Override
    public IRepository<Long, Trabajador> getRepository() {
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

}
