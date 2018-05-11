package edu.utm.bd.mappers;

import java.util.List;
import edu.utm.bd.domain.Proveedor;

public interface ProveedorMapper {
	List<Proveedor> findAllProveedor();
	Proveedor findOneProveedor(Proveedor proveedor);
}
