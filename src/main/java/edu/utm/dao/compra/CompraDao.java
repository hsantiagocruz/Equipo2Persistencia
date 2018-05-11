package edu.utm.dao.compra;

import java.util.List;

import edu.utm.bd.domain.Compra;

public interface CompraDao {
	List <Compra> findAllCompras();
	Compra findOneCompra(Compra compra);
}
