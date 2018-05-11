package edu.utm.dao;

import java.util.List;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import edu.utm.bd.domain.Producto;
import edu.utm.bd.domain.Proveedor;
import edu.utm.dao.proveedor.ProveedorDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ProveedorDaoImpTest {
	@Inject
	ProveedorDao proveedorDao;
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Proveedor> lista = proveedorDao.findAllProveedor();
			//assertEquals(lista.size(),4);
			if( lista.size()>0 ) {
				System.out.println("Consulta todos los proveedores realizada");
			}
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	
	@Test
	public void pruebaBusca1Proveedor() {
		try {
			Proveedor c = new Proveedor();
			Proveedor result=null;
			c.setIdproveedor(1);
			result=proveedorDao.findOneProveedor( c );
			System.out.println("Proveedor encontrado: "+ result.getProvnombre() ); ///
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
}
