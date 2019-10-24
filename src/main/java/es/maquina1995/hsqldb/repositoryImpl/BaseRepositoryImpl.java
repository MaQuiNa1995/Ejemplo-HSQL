package es.maquina1995.hsqldb.repositoryImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.dominio.Base;
import es.maquina1995.hsqldb.repository.BaseRepository;

@Repository
@Transactional
public class BaseRepositoryImpl extends AbstractRepositoryImpl<Long, Base> implements BaseRepository {

    @Override
    public Class<Base> getClassDeT() {
        return Base.class;
    }

    @Override
    public String getNombreTabla() {
        return "Base";
    }
}
