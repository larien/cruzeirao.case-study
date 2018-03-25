package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Cartao;

public class CartaoService {

	private ArrayList <Cartao> cartoes = new ArrayList<Cartao>();
	
	public CartaoService()
	{

	}
	
	public void salvar(Cartao cartao)
	{
		cartoes.add(cartao);
	}

	public void remove(Cartao cartao)
	{
		cartoes.remove(cartao);
	}

	public List <Cartao> getCartoes()
	{
		return cartoes;
	}
	
}
