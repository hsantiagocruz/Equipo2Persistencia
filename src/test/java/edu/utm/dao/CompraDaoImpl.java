package edu.utm.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Compra;
import edu.utm.dao.compra.CompraDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class CompraDaoImpl {
	@Inject
	CompraDao compradao;
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Compra> lista = compradao.findAllCompras();
			//assertEquals(lista.size(),4);
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	@Test
	public void pruebaBusca1Compra() {
		try {
			Compra c = new Compra();
			Compra result=null;
			c.setIdcompra("1");
			result=compradao.findOneCompra(c);
			System.out.println("Compra encontrada: "+result.getComtotal());
		}
		catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
}
