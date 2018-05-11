package sistema.service;

import java.util.List;

import sistema.DAO.CartaoDAO;
import sistema.modelos.Cartao;

public class CartaoService {

	private CartaoDAO dao = new CartaoDAO();
	
	public CartaoService()
	{

	}
	
	public void salvar(Cartao cartao)
	{
		cartao = dao.save(cartao);
		dao.closeEntityManager();
	}
	
	public void alterar(Cartao cartao)
	{
		dao.save(cartao);
		dao.closeEntityManager();
	}

	public void remove(Cartao cartao)
	{
		cartao = dao.getById(Cartao.class, cartao.getId());
		dao.remove(cartao);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Cartao> getCartoes()
	{
		List <Cartao> list = dao.getAll(Cartao.class);
		dao.closeEntityManager();
		return list;
	}
	
}
