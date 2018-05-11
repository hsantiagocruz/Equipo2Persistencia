package edu.utm.dao.venta;

import java.util.List;

import edu.utm.bd.domain.Venta;

public interface VentaDao {
	List <Venta>findAllVentas();
	Venta findOneVenta(Venta venta);
	void insertVenta(Venta venta);
}
