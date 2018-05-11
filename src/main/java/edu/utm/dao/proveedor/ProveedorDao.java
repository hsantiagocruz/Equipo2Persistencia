package edu.utm.dao.proveedor;

import java.util.List;

import edu.utm.bd.domain.Proveedor;

public interface ProveedorDao {
	List<Proveedor> findAllProveedor();
	Proveedor findOneProveedor(Proveedor proveedor);
}
