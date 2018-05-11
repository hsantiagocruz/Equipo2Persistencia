package edu.utm.dao.compra;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Compra;
import edu.utm.bd.mappers.CompraMapper;

@Named
public class CompraDaoImpl implements CompraDao{
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	@Override
	public List<Compra> findAllCompras() {
		List<Compra> list = null;
		try {
			CompraMapper compraMapper = sqlSession.getMapper(CompraMapper.class);
			list = compraMapper.findAllCompras();
			for (Compra c : list) {
				System.out.println("Id: " + c.getIdcompra());
				System.out.println("Nombre" + c.getComtotal());
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllCompras: "+e);
		}
		return list;
	}

	@Override
	public Compra findOneCompra(Compra compra) {
		Compra result=null;
		try {
			CompraMapper compraMapper = sqlSession.getMapper(CompraMapper.class);
			result = compraMapper.findOneCompra(compra);
			System.out.println("Compra "+result.getIdcompra()+" total:"+result.getComtotal());
		} 
		catch(Exception e) {
			System.out.println("Error result: "+e);
		}
		return result;
	}

}
