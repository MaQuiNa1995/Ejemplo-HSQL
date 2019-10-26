package es.maquina1995.hsqldb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina1995.hsqldb.dominio.Base;
import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.BaseRepository;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;

@Service
public class BaseServiceImpl implements BaseService {

    private BaseRepository baseRepository;
    private TrabajadorRepository trabajadorRepository;

    @Override
    public Long aniadirBase(int cantidadMineral, String tipoMineral, int trabajadoresMaximo, long idTrabajador) {

	Trabajador trabajador = trabajadorRepository.readByPk(idTrabajador);

	Base baseAniadir = new Base()
		.setCantidadMineral(cantidadMineral)
		.setTipoMineral(tipoMineral)
		.setTrabajadoresMaximo(trabajadoresMaximo)
		.setTrabajador(trabajador);

	return baseRepository.persist(baseAniadir).getId();
    }

    @Override
    public Base obtenerBase(Long id) {
	return baseRepository.readByPk(id);
    }

    @Override
    public List<Base> obtenerBases() {
	return baseRepository.findAll();
    }

    @Override
    public Base actualizarBase(Base modificada) {
	return baseRepository.merge(modificada);
    }

    @Override
    public void borrarBase(Long id) {
	baseRepository.deleteByPk(id);
    }

    @Autowired
    public void setBaseRepository(BaseRepository baseRepository) {
	this.baseRepository = baseRepository;
    }

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
	this.trabajadorRepository = trabajadorRepository;
    }

}
