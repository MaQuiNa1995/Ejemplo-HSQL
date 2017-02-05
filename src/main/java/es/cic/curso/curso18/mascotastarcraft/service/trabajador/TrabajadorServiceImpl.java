package es.cic.curso.curso18.mascotastarcraft.service.trabajador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso02.ejercicio013.dominio.sala.Sala;
import es.cic.curso.curso02.ejercicio013.dominio.sala.SalaRepository;
import es.cic.curso.curso02.ejercicio013.dominio.sesion.Sesion;
import es.cic.curso.curso02.ejercicio013.dominio.sesion.SesionRepository;

@Service
public class TrabajadorServiceImpl implements SesionService {

	@Autowired
	private SesionRepository sesionRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso02.ejercicio013.service.sesion.SesionService#aniadirSesion(int, boolean, es.cic.curso.curso02.ejercicio013.dominio.sala.Sala)
	 */
	@Override
	public Long aniadirSesion(int asientosOcupados, boolean sesionCerrada, Long  idsala){
		Sesion sesion = new Sesion();
		sesion.setAsientosOcupados(asientosOcupados);
		sesion.setSesionCerrada(sesionCerrada);
		Sala sala = salaRepository.read(idsala);
		sesion.setSala(sala);
		Sesion aniadida = aniadirSesion(sesion);
		
		return aniadida.getId();
	}

	private Sesion aniadirSesion(Sesion nueva) {
		return sesionRepository.add(nueva);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso02.ejercicio013.service.sesion.SesionService#obtenerSesion(java.lang.Long)
	 */
	@Override
	public Sesion obtenerSesion(Long id){
		return sesionRepository.read(id);
	}
	
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso02.ejercicio013.service.sesion.SesionService#obtenerSesiones()
	 */
	@Override
	public List<Sesion> obtenerSesiones(){
		return sesionRepository.list();
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso02.ejercicio013.service.sesion.SesionService#actualizarSesion(es.cic.curso.curso02.ejercicio013.dominio.sesion.Sesion)
	 */
	@Override
	public Sesion actualizarSesion(Sesion modificada){
		return sesionRepository.update(modificada);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso02.ejercicio013.service.sesion.SesionService#borrarSesion(java.lang.Long)
	 */
	@Override
	public void borrarSesion(Long id){
		Sesion aBorrar = obtenerSesion(id);
		sesionRepository.delete(aBorrar);
	}
	
}
