package es.maquina1995.hsqldb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina1995.hsqldb.dominio.Trabajador;
import es.maquina1995.hsqldb.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    private TrabajadorRepository trabajadorRepository;

    @Autowired
    public void setTrabajadorRepository(TrabajadorRepository trabajadorRepository) {
	this.trabajadorRepository = trabajadorRepository;
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador modificada) {
	return trabajadorRepository.merge(modificada);
    }

    @Override
    public Long aniadirTrabajador(String tipoTrabajador) {
	Trabajador trabajador = new Trabajador();
	trabajador.setTipoTrabajador(tipoTrabajador);

	Trabajador aniadida = aniadirTrabajador(trabajador);

	return aniadida.getId();
    }

    private Trabajador aniadirTrabajador(Trabajador nueva) {
	return trabajadorRepository.persist(nueva);
    }

    @Override
    public void borrarTrabajador(Long id) {
	trabajadorRepository.deleteByPk(id);
    }

    @Override
    public Trabajador obtenerTrabajador(Long id) {
	return trabajadorRepository.readByPk(id);
    }

    @Override
    public List<Trabajador> obtenerTrabajadores() {
	return trabajadorRepository.findAll();
    }
}
