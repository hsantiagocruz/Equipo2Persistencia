package edu.utm.dao.proveedor;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Proveedor;
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
	public void updateProveedor (Proveedor proveedor){
		try{
			
			ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
			proveedorMapper.updateProveedor(proveedor);
			System.out.println("Proveedor "+ proveedor.getProvnombre() +" actualizado");
		}
		
		catch(Exception e){
			System.out.println("Error updateCliente: "+e);
		}
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
	
	@Override
	public void insertProveedor(Proveedor proveedor) {
		try {
			ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
			proveedorMapper.insertProveedor(proveedor);
			System.out.println("Proveedor " + proveedor.getProvnombre() +" insertado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}

	@Override
	public void deleteOneProveedor(Proveedor proveedor) {
		try {
			ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
			proveedorMapper.deleteOneProveedor(proveedor);
			System.out.println("Proveedor "+proveedor.getProvnombre() +" eliminado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	

}
