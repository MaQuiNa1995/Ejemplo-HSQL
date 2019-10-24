package es.maquina1995.hsqldb.repository;

import org.springframework.stereotype.Repository;

import es.maquina1995.hsqldb.dominio.Base;

@Repository
public class BaseRepositoryImpl extends GenericCrudRepositoryImpl<Long, Base> implements BaseRepository {

    @Override
    public Class<Base> getClassDeT() {
	return Base.class;
    }

    @Override
    public String getNombreTabla() {
	return "BASE";
    }
}
