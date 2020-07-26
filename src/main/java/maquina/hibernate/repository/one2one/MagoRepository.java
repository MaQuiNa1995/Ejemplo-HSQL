package maquina.hibernate.repository.one2one;

import maquina.hibernate.dominio.one2one.Mago;
import maquina.hibernate.repository.JpaRepository;

public interface MagoRepository
		extends JpaRepository < Long, Mago >
{

}