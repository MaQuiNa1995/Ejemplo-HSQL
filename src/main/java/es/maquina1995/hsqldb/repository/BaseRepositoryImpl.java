package es.maquina1995.hsqldb.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Base;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BaseRepositoryImpl extends CrudRepositoryImpl<Long, Base> implements BaseRepository {

    @Override
    public Class<Base> getClassDeT() {
	return Base.class;
    }

    @Override
    public String getNombreTabla() {
	return "BASE";
    }
}
