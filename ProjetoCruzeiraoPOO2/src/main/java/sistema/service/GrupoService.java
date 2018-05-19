package sistema.service;

import java.util.List;

import sistema.DAO.GrupoDAO;
import sistema.modelos.Grupo;

public class GrupoService {

	private GrupoDAO dao = new GrupoDAO();
	
	public GrupoService()
	{

	}
	
	public void salvar(Grupo grupo)
	{
		grupo = dao.save(grupo);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Grupo grupo)
	{
		dao.save(grupo);
		dao.closeEntityManager();
	}

	public void remove(Grupo grupo)
	{
		grupo = dao.getById(Grupo.class, grupo.getId());
		dao.remove(grupo);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Grupo> getGrupos()
	{
		List <Grupo> list = dao.getAll(Grupo.class);
		dao.closeEntityManager();
		return list;
	}

	
}
