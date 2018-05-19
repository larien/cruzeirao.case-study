package sistema.service;

import java.util.List;

import sistema.DAO.InscritoDAO;
import sistema.modelos.Inscrito;

public class InscritoService {

	private InscritoDAO dao = new InscritoDAO();
	
	public InscritoService()
	{

	}
	
	public void salvar(Inscrito inscrito)
	{
		inscrito = dao.save(inscrito);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Inscrito inscrito)
	{
		dao.save(inscrito);
		dao.closeEntityManager();
	}

	public void remove(Inscrito inscrito)
	{
		inscrito = dao.getById(Inscrito.class, inscrito.getId());
		dao.remove(inscrito);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Inscrito> getInscritos()
	{
		List <Inscrito> list = dao.getAll(Inscrito.class);
		dao.closeEntityManager();
		return list;
	}

	
}
