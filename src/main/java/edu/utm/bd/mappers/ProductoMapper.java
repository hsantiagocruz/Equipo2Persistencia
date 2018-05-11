package edu.utm.bd.mappers;

import java.util.List;
import edu.utm.bd.domain.Producto;

public interface ProductoMapper {
	List<Producto> findAllProductos();
	Producto findOneProducto(Producto producto);
}
