package es.maquina1995.hsqldb.service;

import java.util.List;

import es.maquina1995.hsqldb.dominio.Base;

public interface BaseService {

    public Base actualizarBase(Base modificada);

    public Long aniadirBase(int cantidadMineral, String tipoMineral, int trabajadoresMaximo, long... idArrayTrabajadores);

    public void borrarBase(Long id);

    public Base obtenerBase(Long id);

    public List<Base> obtenerBases();

}
