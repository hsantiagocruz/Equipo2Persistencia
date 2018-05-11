package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Factura;

public interface FacturaMapper {
	List <Factura> findAllFacturas();
	Factura findOneFactura(Factura factura);
	Factura findOneFacturaxFecha(Factura factura);
}
