package es.maquina1995.hsqldb.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Mapa;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class MapaRepositoryImpl extends CrudRepositoryImpl<Long, Mapa> implements MapaRepository {

    @Override
    public Class<Mapa> getClassDeT() {
	return Mapa.class;
    }

    @Override
    public String getNombreTabla() {
	return "MAPA";
    }
}
