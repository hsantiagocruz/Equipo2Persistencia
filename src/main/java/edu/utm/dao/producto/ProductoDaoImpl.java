package edu.utm.dao.producto;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Producto;
import edu.utm.bd.mappers.ProductoMapper;

@Named
public class ProductoDaoImpl implements ProductoDao{
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<Producto> findAllProductos() {
		List<Producto> list = null;
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.findAllProductos();
			for (Producto c : list) {
				System.out.println("Id: " + c.getIdproduco() );
				System.out.println("Nombre de producto" + c.getPronombre() );
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllFacturas: "+e);
		}
		return list;
	}
	
	@Override
	public Producto findOneProducto(Producto producto) {
		Producto result=null;
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			result = productoMapper.findOneProducto( producto );
			System.out.println("Producto id: "+ result.getIdproduco() +", nombre: "+ result.getPronombre() +" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneFactura: "+e);
		}
		return result;
	}
	
	
}
