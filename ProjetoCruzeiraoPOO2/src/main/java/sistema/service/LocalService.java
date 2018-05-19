package sistema.service;

import java.util.List;

import sistema.DAO.LocalDAO;
import sistema.modelos.Local;

public class LocalService {

	private LocalDAO dao = new LocalDAO();
	
	public LocalService()
	{

	}
	
	public void salvar(Local local)
	{
		local = dao.save(local);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Local local)
	{
		dao.save(local);
		dao.closeEntityManager();
	}

	public void remove(Local local)
	{
		local = dao.getById(Local.class, local.getId());
		dao.remove(local);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Local> getLocais()
	{
		List <Local> list = dao.getAll(Local.class);
		dao.closeEntityManager();
		return list;
	}
	
}
