package edu.utm.dao.proveedor;

import java.util.List;

import edu.utm.bd.domain.Proveedor;

public interface ProveedorDao {
	List<Proveedor> findAllProveedor();
	void updateProveedor(Proveedor proveedor);
	Proveedor findOneProveedor(Proveedor proveedor);
	void insertProveedor(Proveedor proveedor);
	void deleteOneProveedor(Proveedor proveedor);

}
