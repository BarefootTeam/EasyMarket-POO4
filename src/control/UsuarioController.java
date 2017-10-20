package control;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public Usuario buscarPorId(Long id) {
		return UsuarioDAO.getInstance().buscarPorId(id);
	}

}
