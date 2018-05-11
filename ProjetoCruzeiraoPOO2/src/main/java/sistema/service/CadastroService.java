package sistema.service;

import java.util.List;

import sistema.DAO.UsuarioDAO;
import sistema.modelos.Usuario;

public class CadastroService {

	private UsuarioDAO dao = new UsuarioDAO();
	
	
	public CadastroService()
	{
		
	}
	
	public void salvar(Usuario cadastro)
	{
		cadastro = dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void alterar(Usuario cadastro)
	{
		dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void remove(Usuario cadastro)
	{
		cadastro = dao.getById(Usuario.class, cadastro.getId());
		dao.remove(cadastro);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> getCadastros()
	{
		List <Usuario> list = dao.getAll(Usuario.class);
		dao.closeEntityManager();
		return list;
		
	}
	
}
