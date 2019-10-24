package es.maquina1995.hsqldb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;
import es.maquina1995.hsqldb.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	private TrabajadorRepository trabajadorRepository;

	@Autowired
    public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }
	
	@Override
	public Trabajador actualizarTrabajador(Trabajador modificada) {
		return trabajadorRepository.update(modificada);
	}

	@Override
	public Long aniadirTrabajador(String tipoTrabajador) {
		Trabajador trabajador = new Trabajador();
		trabajador.setTipoTrabajador(tipoTrabajador);

		Trabajador aniadida = aniadirTrabajador(trabajador);

		return aniadida.getId();
	}

	private Trabajador aniadirTrabajador(Trabajador nueva) {
		return trabajadorRepository.add(nueva);
	}

	@Override
	public void borrarTrabajador(Long id) {
		Trabajador aBorrar = obtenerTrabajador(id);
		trabajadorRepository.delete(aBorrar);
	}

	@Override
	public Trabajador obtenerTrabajador(Long id) {
		return trabajadorRepository.read(id);
	}

	@Override
	public List<Trabajador> obtenerTrabajadors() {
		return trabajadorRepository.list();
	}
}
