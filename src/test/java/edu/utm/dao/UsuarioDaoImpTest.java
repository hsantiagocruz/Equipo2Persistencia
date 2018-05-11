package edu.utm.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import edu.utm.bd.domain.Usuario;
import edu.utm.dao.usuario.UsuarioDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UsuarioDaoImpTest {
	@Inject
	UsuarioDao usuarioDao;
	
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Usuario> lista = usuarioDao.findAllUsuarios();
			//assertEquals(lista.size(),4);
			if( lista.size()>=1 ) {
				System.out.println("Consulta de todos los usuarios");
			}
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaActualizarUsuario() {
		try {
			Usuario c = new Usuario();
			c.setIdusuario(1);
			c.setUsuadmin(true);
			c.setUsuapellidos("Torres Bautista");
			c.setUsunick("Nuevo nick");
			c.setUsunombre(" Fernando ");
			c.setUsupass("torres");
			usuarioDao.updateUsuario(c);
			System.out.println("fin de la actualizacion de usuario");
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaBusca1Usuario() {
		try {
			Usuario c = new Usuario();
			Usuario result=null;
			c.setIdusuario(1);;
			result=usuarioDao.findOneUsuario(c);
			System.out.println("Usuario encontrado: "+result.getUsunombre() );
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaInsertaUsuario() {
		try {
			Usuario c = new Usuario();
			c.setIdusuario(2);
			c.setUsuadmin(false);
			c.setUsuapellidos("No se");
			c.setUsunick("Nickname");
			c.setUsunombre(" Juan Pepe ");
			c.setUsupass("no");
			usuarioDao.insertUsuario(c);
			System.out.println("Usuario insertado: "+ c.getUsunombre() );
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaEliminaUsuario() {
		try {
			Usuario c = new Usuario();
			c.setIdusuario(2);			
			usuarioDao.deleteOneUsuario(c);
			System.out.println("Usuario emilinado: "+ c.getUsunombre() );
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
}
