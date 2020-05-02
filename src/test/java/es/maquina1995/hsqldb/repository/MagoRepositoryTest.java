package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.dominio.Mago;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class}) // , LiquibaseConfig.class 
public class MagoRepositoryTest extends CrudRepositoryImplTest<Long, Mago> {

    private MagoRepository cut;

    @Override
    public CrudRepository<Long, Mago> getRepository() {
	return cut;
    }

    @Override
    public Mago getInstanceDeTParaNuevo() {
	Mago mago = new Mago();
	mago.setNombre("Mago Negro");
	
	return mago;
    }

    @Override
    public Mago getInstanceDeTParaLectura() {
	Mago mago = new Mago();
	mago.setNombre("Mago Negro");
	return mago;
    }

    @Override
    public boolean sonDatosIguales(Mago mago1, Mago mago2) {
	return mago1.equals(mago2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public Mago getInstanceDeTParaModificar(Long clave) {
	Mago mago = getInstanceDeTParaLectura();
	mago.setId(clave);
	mago.setNombre("Mago Negro");

	return mago;
    }

    @Autowired
    public void setMagoRepository(MagoRepository sut) {
	this.cut = sut;
    }
}
