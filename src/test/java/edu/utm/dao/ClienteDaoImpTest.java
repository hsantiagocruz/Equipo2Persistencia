package edu.utm.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import edu.utm.bd.domain.Cliente;
import edu.utm.dao.cliente.ClienteDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteDaoImpTest {
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Cliente> lista = clienteDao.findAllClientes();
			//assertEquals(lista.size(),4);
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaActualizar() {
		try {
			Cliente c = new Cliente();
			c.setIdcliente(1);
			c.setClinombre("Hector");
			c.setCliapellidos("Santiago Cruz");
			c.setClitelefono("1234567891");
			c.setClidireccion("");
			clienteDao.updateCliente(c);
			System.out.println("fin de la actualizacion");
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaBusca1Cliente() {
		try {
			Cliente c = new Cliente();
			Cliente result=null;
			c.setIdcliente(4);
			result=clienteDao.findOneCliente(c);
			System.out.println("Cliente encontrado: "+result.getClinombre());
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaInsertaCliente() {
		try {
			Cliente c = new Cliente();
			c.setClinombre("Juan");
			c.setCliapellidos("Cruz");
			c.setClitelefono("1234567891");
			c.setClidireccion("");
			clienteDao.insertCliente(c);
			System.out.println("Cliente insertado: "+c.getClinombre());
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaEliminaCliente() {
		try {
			Cliente c = new Cliente();
			c.setIdcliente(8);
			clienteDao.deleteOneCliente(c);
			System.out.println("Cliente emilinado: "+c.getIdcliente());
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
}
