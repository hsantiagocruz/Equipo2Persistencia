package edu.utm.dao.producto;

import java.util.List;
import edu.utm.bd.domain.Producto;

public interface ProductoDao {
	List <Producto> findAllProductos();
	Producto findOneProducto(Producto producto);
}
