package edu.utm.dao.venta;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Venta;
import edu.utm.bd.mappers.VentaMapper;

@Named
public class VentaDaoImpl implements VentaDao{
	
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<Venta> findAllVentas() {
		List<Venta> list = null;
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			list = ventaMapper.findAllVentas();
			for (Venta v : list) {
				System.out.println("Id: " + v.getIdventa());
				System.out.println("VentaFecha: " + v.getVenfecha());
				System.out.println("Venta Total " + v.getVentotal());
				System.out.println("Cliente_Id: " + v.getClienteId());
				System.out.println("Usuario_Id: " + v.getUsuarioId());
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllVentas: "+e);
		}
		return list;
	}
	


	@Override
	public Venta findOneVenta(Venta venta) {
		Venta result=null;
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			result=ventaMapper.findOneVenta(venta);
			System.out.println("Venta "+result.getIdventa()+" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneVenta: "+e);
		}
		return result;
	}

	@Override
	public void insertVenta(Venta venta) {
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			ventaMapper.insertVenta(venta);
			System.out.println("Venta "+ venta.getIdventa());
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}

}
