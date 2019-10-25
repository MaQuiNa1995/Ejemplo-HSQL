package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Mapa;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class MapaRepositoryTest extends CrudRepositoryImplTest<Long, Mapa> {

    private MapaRepository cut;

    @Override
    public CrudRepository<Long, Mapa> getRepository() {
	return cut;
    }

    @Override
    public Mapa getInstanceDeTParaNuevo() {
	Mapa mapaTest = new Mapa();
	mapaTest.setNombreMapa("Ocean");
	return mapaTest;
    }

    @Override
    public Mapa getInstanceDeTParaLectura() {
	Mapa mapaTest = new Mapa();
	mapaTest.setNombreMapa("Ocean");
	return mapaTest;
    }

    @Override
    public boolean sonDatosIguales(Mapa t1, Mapa t2) {
	if (t1 == null || t2 == null) {
	    throw new UnsupportedOperationException("No puedo comparar nulos");
	}

	if (!t1.getNombreMapa().equals(t2.getNombreMapa())) {
	    return false;
	}

	return true;
    }

    @Override
    public Long getClavePrimariaNoExistente() {

	return Long.MAX_VALUE;
    }

    @Override
    public Mapa getInstanceDeTParaModificar(Long clave) {
	Mapa trabajador = getInstanceDeTParaLectura();
	trabajador.setId(clave);
	trabajador.setNombreMapa("Ocean");
	return trabajador;
    }

    @Autowired
    public void setMapaRepository(MapaRepository sut) {
	this.cut = sut;
    }

}
