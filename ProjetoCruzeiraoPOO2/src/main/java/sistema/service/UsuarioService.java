package sistema.service;

import java.util.List;

import sistema.DAO.UsuarioDAO;
import sistema.modelos.Usuario;

public class UsuarioService {

	private UsuarioDAO dao = new UsuarioDAO();
	
	public UsuarioService()
	{

	}
	
	public void salvar(Usuario usuario)
	{
		usuario = dao.save(usuario);
		dao.closeEntityManager();
	}
	
	public void alterar(Usuario cadastro)
	{
		dao.save(cadastro);
		dao.closeEntityManager();
	}

	public void remove(Usuario usuario)
	{
		usuario = dao.getById(Usuario.class, usuario.getId());
		dao.remove(usuario);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> getUsuarios()
	{
		List <Usuario> list = dao.getAll(Usuario.class);
		dao.closeEntityManager();
		return list;
	}
	
}
