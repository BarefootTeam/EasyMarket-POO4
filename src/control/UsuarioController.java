package control;

import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public Usuario buscarPorId(Long id) {
		return UsuarioDAO.getInstance().buscarPorId(id);
	}
	
	public boolean persistir(Usuario usuario) {
		return UsuarioDAO.getInstance().persistir(usuario) != null;
	}
	
	public List<Usuario> buscarTodos() {
		return UsuarioDAO.getInstance().buscarTodos();
	}

	public boolean deletar(Usuario usuario) {
		return UsuarioDAO.getInstance().deletar(usuario);
	}

}
