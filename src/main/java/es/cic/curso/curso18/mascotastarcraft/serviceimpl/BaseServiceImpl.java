package es.cic.curso.curso18.mascotastarcraft.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso18.mascotastarcraft.dominio.Base;
import es.cic.curso.curso18.mascotastarcraft.dominio.Trabajador;
import es.cic.curso.curso18.mascotastarcraft.repository.BaseRepository;
import es.cic.curso.curso18.mascotastarcraft.repository.TrabajadorRepository;
import es.cic.curso.curso18.mascotastarcraft.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService {

    private BaseRepository baseRepository;
    private TrabajadorRepository trabajadorRepository;
    
	@Autowired
	public void setBaseRepository(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Autowired
	public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
		this.trabajadorRepository = trabajadorRepository;
	}

    @Override
    public Long aniadirBase(int cantidadMineral, String tipoMineral, int TrabajadoresMaximo, long idTrabajador) {

        Base base = new Base();
        base.setCantidadMineral(cantidadMineral);
        base.setTipoMineral(tipoMineral);
        base.setTrabajadoresMaximo(TrabajadoresMaximo);
        Trabajador trabajador = trabajadorRepository.read(idTrabajador);
        base.setTrabajador(trabajador);
        Base aniadida = aniadirBase(base);

        return aniadida.getId();
    }

    private Base aniadirBase(Base nueva) {
        return baseRepository.add(nueva);
    }

    @Override
    public Base obtenerBase(Long id) {
        return baseRepository.read(id);
    }

    @Override
    public List<Base> obtenerBases() {
        return baseRepository.list();
    }

    @Override
    public Base actualizarBase(Base modificada) {
        return baseRepository.update(modificada);
    }

    @Override
    public void borrarBase(Long id) {
        Base aBorrar = obtenerBase(id);
        baseRepository.delete(aBorrar);
    }

}
