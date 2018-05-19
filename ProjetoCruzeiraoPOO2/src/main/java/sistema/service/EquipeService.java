package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.DAO.EquipeDAO;
import sistema.modelos.Equipe;

public class EquipeService {

	private EquipeDAO dao = new EquipeDAO();
	
	public EquipeService()
	{

	}
	
	public void salvar(Equipe equipe)
	{
		equipe = dao.save(equipe);
		dao.closeEntityManager();
	}
	
	public void alterar(Equipe equipe)
	{
		dao.save(equipe);
		dao.closeEntityManager();
	}

	public void remove(Equipe equipe)
	{
		equipe = dao.getById(Equipe.class, equipe.getId());
		dao.remove(equipe);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Equipe> getEquipes()
	{
		List <Equipe> list = dao.getAll(Equipe.class);
		dao.closeEntityManager();
		return list;
	}

	
}
