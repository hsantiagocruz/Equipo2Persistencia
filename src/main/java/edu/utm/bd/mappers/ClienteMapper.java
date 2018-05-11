package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Cliente;

public interface ClienteMapper {
	List <Cliente> findAllClientes();
	void updateCliente(Cliente cliente);
	Cliente findOneCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	void deleteOneCliente(Cliente cliente);
}