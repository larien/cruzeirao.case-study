package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Cartao;
import sistema.service.CartaoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class CartaoMB {
	private CartaoService service = new CartaoService();
	private Cartao cartao = new Cartao();
	
	public void salvar()
	{
		service.salvar(cartao);
		cartao = new Cartao();
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public void remover(Cartao cartao) {
		service.remove(cartao);
	} 

	public List<Cartao> getCartoes() {
		return service.getCartoes();
	}
}
