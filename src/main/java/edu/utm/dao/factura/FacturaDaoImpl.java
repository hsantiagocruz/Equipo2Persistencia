package edu.utm.dao.factura;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Factura;
import edu.utm.bd.mappers.FacturaMapper;

@Named
public class FacturaDaoImpl implements FacturaDao {
	
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<Factura> findAllFacturas() {
		List<Factura> list = null;
		try {
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			list = facturaMapper.findAllFacturas();
			for (Factura c : list) {
				System.out.println("Id: " + c.getIdfactura() );
				System.out.println("Nombre" + c.getFacfecha() );
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllFacturas: "+e);
		}
		return list;
	}

	@Override
	public Factura findOneFactura(Factura factura) {
		Factura result=null;
		try {
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			result = facturaMapper.findOneFactura( factura );
			System.out.println("Factura "+result.getVentaId()+", "+ result.getVentaId()+" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneFactura: "+e);
		}
		return result;
	}

	@Override
	public Factura findOneFacturaxFecha(Factura factura) {
		Factura result=null;
		try {
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			result = facturaMapper.findOneFacturaxFecha( factura );
			System.out.println("Factura "+result.getVentaId()+", "+ result.getVentaId()+" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneFactura: "+e);
		}
		return result;
	}
}
