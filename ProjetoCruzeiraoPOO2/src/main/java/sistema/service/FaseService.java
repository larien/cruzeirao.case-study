package sistema.service;

import java.util.List;

import sistema.DAO.FaseDAO;
import sistema.modelos.Fase;

public class FaseService {

	private FaseDAO dao = new FaseDAO();
	
	public FaseService()
	{

	}
	
	public void salvar(Fase fase)
	{
		fase = dao.save(fase);
		dao.closeEntityManager();
	}
	
	public void alterar(Fase fase)
	{
		dao.save(fase);
		dao.closeEntityManager();
	}

	public void remove(Fase fase)
	{
		fase = dao.getById(Fase.class, fase.getId());
		dao.remove(fase);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Fase> getFases()
	{
		List <Fase> list = dao.getAll(Fase.class);
		dao.closeEntityManager();
		return list;
	}


}
