package sistema.service;

import java.util.List;

import sistema.DAO.CategoriaDAO;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;

public class CategoriaService {

	private CategoriaDAO dao = new CategoriaDAO();
	
	public CategoriaService()
	{

	}
	
	public void salvar(Categoria categoria)
	{
		categoria = dao.save(categoria);
		dao.closeEntityManager();
	}
	
	public void alterar(Categoria categoria)
	{
		dao.save(categoria);
		dao.closeEntityManager();
	}

	public void remove(Categoria categoria)
	{
		categoria = dao.getById(Categoria.class, categoria.getId());
		dao.remove(categoria);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Categoria> getCategorias()
	{
		List <Categoria> list = dao.getAll(Categoria.class);
		dao.closeEntityManager();
		return list;
	}

	
}
