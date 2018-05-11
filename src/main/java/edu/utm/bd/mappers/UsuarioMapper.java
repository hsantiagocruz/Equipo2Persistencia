package edu.utm.bd.mappers;

import java.util.List;
import edu.utm.bd.domain.Usuario;

public interface UsuarioMapper {
	List <Usuario> findAllUsuarios();
	void updateUsuario(Usuario usuario);
	Usuario findOneUsuario(Usuario usuario);
	void insertUsuario(Usuario usuario);
	void deleteOneUsuario(Usuario usuario);
}
