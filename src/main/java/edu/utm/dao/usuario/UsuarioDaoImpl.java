package edu.utm.dao.usuario;

import java.util.List;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Usuario;
import edu.utm.bd.mappers.ClienteMapper;
import edu.utm.bd.mappers.UsuarioMapper;

@Named
public class UsuarioDaoImpl implements UsuarioDao {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		List<Usuario> list = null;
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			list = usuarioMapper.findAllUsuarios();
			for (Usuario c : list) {
				System.out.println("Id usuario: " + c.getIdusuario() );
				System.out.println("Nombre de usuario: " + c.getUsunombre() );
			}
			return list;
		} 
		catch(Exception e) {
			System.out.println("Error findAllClientes: "+e);
		}
		return list;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.updateUsuario(usuario);
			System.out.println("Usuario "+ usuario.getUsunombre() +" actualizado");
		} 
		catch(Exception e){
			System.out.println("Error updateCliente: "+e);
		}
	}

	@Override
	public Usuario findOneUsuario(Usuario usuario) {
		Usuario result=null;
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			result=usuarioMapper.findOneUsuario(usuario);
			System.out.println("Usuario "+result.getUsunombre()+" encontrado");
		}
		catch(Exception e){
			System.out.println("Error findOneCliente: "+e);
		}
		return result;
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.insertUsuario(usuario);
			System.out.println("Usuario "+usuario.getUsunombre()+" insertado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}

	@Override
	public void deleteOneUsuario(Usuario usuario) {
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.deleteOneUsuario(usuario);
			System.out.println("Usuario "+usuario.getUsunombre() +" eliminado");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
}
