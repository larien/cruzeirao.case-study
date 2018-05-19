package sistema.service;

import java.util.List;

import sistema.DAO.InscricaoDAO;
import sistema.modelos.Inscricao;

public class InscricaoService {

	private InscricaoDAO dao = new InscricaoDAO();
	
	public InscricaoService()
	{

	}
	
	public void salvar(Inscricao inscricao)
	{
		inscricao = dao.save(inscricao);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Inscricao inscricao)
	{
		dao.save(inscricao);
		dao.closeEntityManager();
	}

	public void remove(Inscricao inscricao)
	{
		inscricao = dao.getById(Inscricao.class, inscricao.getId());
		dao.remove(inscricao);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Inscricao> getInscricoes()
	{
		List <Inscricao> list = dao.getAll(Inscricao.class);
		dao.closeEntityManager();
		return list;
	}


}
