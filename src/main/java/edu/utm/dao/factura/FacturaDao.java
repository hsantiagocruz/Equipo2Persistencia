package edu.utm.dao.factura;

import java.util.List;
import edu.utm.bd.domain.Factura;

public interface FacturaDao {
	List <Factura> findAllFacturas();
	Factura findOneFactura(Factura factura);
	Factura findOneFacturaxFecha(Factura factura);
}
