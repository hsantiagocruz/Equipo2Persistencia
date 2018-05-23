package edu.utm.dao.cliente;

import java.util.List;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.mappers.ClienteMapper;

@Named
public class ClienteDaoImpl implements ClienteDao {
	
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<Cliente> findAllClientes() {
		List<Cliente> list = null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.findAllClientes();
			for (Cliente c : list) {
				System.out.println("Id: " + c.getIdcliente());
				System.out.println("Nombre" + c.getClinombre());
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllClientes: "+e);
		}
		return list;
	}
	
	@Override
	public void updateCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession
					.getMapper(ClienteMapper.class);
			clienteMapper.updateCliente(cliente);
			//System.out.println("Cliente "+cliente.getIdcliente()+" actualizado");
		} 
		catch(Exception e){
			System.out.println("Error updateCliente: "+e);
		}
			
	}

	@Override
	public Cliente findOneCliente(Cliente cliente) {
		Cliente result=null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			result=clienteMapper.findOneCliente(cliente);
			System.out.println("Cliente "+result.getIdcliente()+" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneCliente: "+e);
		}
		return result;
	}

	@Override
	public void insertCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.insertCliente(cliente);
			System.out.println("Cliente "+cliente.getClinombre()+" insertado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	@Override
	public void deleteOneCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.deleteOneCliente(cliente);
			System.out.println("Cliente "+cliente.getClinombre()+" eliminado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
