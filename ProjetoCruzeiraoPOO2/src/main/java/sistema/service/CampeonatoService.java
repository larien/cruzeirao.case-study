package sistema.service;

import java.util.List;

import sistema.DAO.CampeonatoDAO;
import sistema.modelos.Campeonato;

public class CampeonatoService {

	private CampeonatoDAO dao = new CampeonatoDAO();
	
	public CampeonatoService()
	{
		
	}

	public void salvar(Campeonato campeonato)
	{
		campeonato = dao.save(campeonato);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Campeonato campeonato)
	{
		dao.save(campeonato);
		dao.closeEntityManager();
	}

	public void remove(Campeonato campeonato)
	{
		campeonato = dao.getById(Campeonato.class, campeonato.getId());
		dao.remove(campeonato);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Campeonato> getCampeonatos()
	{
		List <Campeonato> list = dao.getAll(Campeonato.class);
		dao.closeEntityManager();
		return list;
	}

}
