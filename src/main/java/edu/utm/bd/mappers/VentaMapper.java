package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Venta;

public interface VentaMapper {
 List<Venta> findAllVentas();
 Venta findOneVenta(Venta venta);
 void insertVenta(Venta venta);
}
