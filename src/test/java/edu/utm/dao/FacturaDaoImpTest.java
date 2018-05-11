package edu.utm.dao;

import java.util.List;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import edu.utm.bd.domain.Factura;
import edu.utm.dao.factura.FacturaDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class FacturaDaoImpTest {
	@Inject
	FacturaDao facturaDao;
	
	@Test
	public void pruebaConsultarT() {
		try {
			List<Factura> lista = facturaDao.findAllFacturas();
			//assertEquals(lista.size(),4);
			if( lista.size()>0 ) {
				System.out.println("Consulta todas las facturas");
			}
		}catch(Exception ex) {
			System.out.println("error "+ex);
		}
	}
	
}
