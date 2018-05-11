package edu.utm.dao;

import java.util.List;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import edu.utm.bd.domain.Producto;
import edu.utm.dao.producto.ProductoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ProductoDaoImpTest {
	@Inject
	ProductoDao productoDao;
	
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Producto> lista = productoDao.findAllProductos();
			//assertEquals(lista.size(),4);
			if( lista.size()>0 ) {
				System.out.println("Consulta todas las facturas realizada");
			}
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	
	@Test
	public void pruebaBusca1Producto() {
		try {
			Producto c = new Producto();
			Producto result=null;
			c.setIdproduco(1);
			result=productoDao.findOneProducto( c );
			System.out.println("Producto encontrado: "+ result.getPronombre() );
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
}
