package sistema.service;

import java.util.List;

import sistema.DAO.PartidaFutebolDAO;
import sistema.modelos.PartidaFutebol;

public class PartidaFutebolService {

	private PartidaFutebolDAO dao = new PartidaFutebolDAO();
	
	public PartidaFutebolService()
	{

	}
	
	public void salvar(PartidaFutebol partidaFutebol)
	{
		partidaFutebol = dao.save(partidaFutebol);
		dao.closeEntityManager();
		
	}
	
	public void alterar(PartidaFutebol partidaFutebol)
	{
		dao.save(partidaFutebol);
		dao.closeEntityManager();
	}

	public void remove(PartidaFutebol partidaFutebol)
	{
		partidaFutebol = dao.getById(PartidaFutebol.class, partidaFutebol.getId());
		dao.remove(partidaFutebol);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <PartidaFutebol> getPartidasFutebol()
	{
		List <PartidaFutebol> list = dao.getAll(PartidaFutebol.class);
		dao.closeEntityManager();
		return list;
	}

}
