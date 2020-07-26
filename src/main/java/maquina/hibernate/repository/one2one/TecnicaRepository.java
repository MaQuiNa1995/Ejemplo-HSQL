package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Tecnica;
import maquina.hibernate.repository.JpaRepository;

public interface TecnicaRepository
		extends JpaRepository < Long, Tecnica >
{

}