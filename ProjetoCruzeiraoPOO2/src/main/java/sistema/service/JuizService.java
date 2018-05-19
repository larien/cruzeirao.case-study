package sistema.service;

import java.util.List;

import sistema.DAO.JuizDAO;
import sistema.modelos.Juiz;

public class JuizService {

	private JuizDAO dao = new JuizDAO();
	
	public JuizService()
	{

	}
	
	public void salvar(Juiz juiz)
	{
		juiz = dao.save(juiz);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Juiz juiz)
	{
		dao.save(juiz);
		dao.closeEntityManager();
	}

	public void remove(Juiz juiz)
	{
		juiz = dao.getById(Juiz.class, juiz.getId());
		dao.remove(juiz);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Juiz> getJuizes()
	{
		List <Juiz> list = dao.getAll(Juiz.class);
		dao.closeEntityManager();
		return list;
	}

}
