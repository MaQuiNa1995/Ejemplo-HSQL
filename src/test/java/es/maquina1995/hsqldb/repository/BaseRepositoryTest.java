package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Base;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class BaseRepositoryTest extends CrudRepositoryImplTest<Long, Base> {

    private BaseRepository cut;

    @Override
    public CrudRepository<Long, Base> getRepository() {
	return cut;
    }

    @Override
    public Base getInstanceDeTParaNuevo() {
	Base baseTest = new Base();
	baseTest.setTipoMineral("Vespeno");
	return baseTest;
    }

    @Override
    public Base getInstanceDeTParaLectura() {
	Base baseTest = new Base();
	baseTest.setTipoMineral("Vespeno");
	return baseTest;
    }

    @Override
    public boolean sonDatosIguales(Base base1, Base base2) {
	return base1.equals(base2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Base getInstanceDeTParaModificar(Long clave) {
	Base base = getInstanceDeTParaLectura().setTipoMineral("Vespeno");
	// No se usa el id con la fluent api porque normalmente no tienes porque setear
		// la variable y asi está diseñado el dominio con esto en mente
	base.setId(clave);
	
	return base;
    }

    @Autowired
    public void setBaseRepository(BaseRepository sut) {
	this.cut = sut;
    }
}
