package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Compra;

public interface CompraMapper {
	List <Compra> findAllCompras();
	Compra findOneCompra(Compra compra);
}
