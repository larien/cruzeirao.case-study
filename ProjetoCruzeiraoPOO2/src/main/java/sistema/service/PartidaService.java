package sistema.service;

import java.util.List;

import sistema.DAO.PartidaDAO;
import sistema.modelos.Partida;

public class PartidaService {

	private PartidaDAO dao = new PartidaDAO();
	
	public PartidaService()
	{

	}
	
	public void salvar(Partida partida)
	{
		partida = dao.save(partida);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Partida partida)
	{
		dao.save(partida);
		dao.closeEntityManager();
	}

	public void remove(Partida partida)
	{
		partida = dao.getById(Partida.class, partida.getId());
		dao.remove(partida);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Partida> getPartidas()
	{
		List <Partida> list = dao.getAll(Partida.class);
		dao.closeEntityManager();
		return list;
	}

}
