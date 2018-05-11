package edu.utm.dao.proveedor;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Producto;
import edu.utm.bd.domain.Proveedor;
import edu.utm.bd.mappers.ProductoMapper;
import edu.utm.bd.mappers.ProveedorMapper;

@Named
public class ProveedorDaoImpl implements ProveedorDao{
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<Proveedor> findAllProveedor() {
		List<Proveedor> list = null;
		try {
			ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
			list = proveedorMapper.findAllProveedor();
			for (Proveedor c : list) {
				System.out.println("Id: " + c.getIdproveedor() );
				System.out.println("Nombre de proveedor" + c.getProvnombre() );
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllFacturas: "+e);
		}
		return list;
	}

	@Override
	public Proveedor findOneProveedor(Proveedor proveedor) {
		Proveedor result=null;
		try {
			ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
			result = proveedorMapper.findOneProveedor( proveedor );
			System.out.println("Proveedor id: "+ result.getIdproveedor() +", nombre: "+ result.getProvnombre() +" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneFactura: "+e);
		}
		return result;
	}

}
