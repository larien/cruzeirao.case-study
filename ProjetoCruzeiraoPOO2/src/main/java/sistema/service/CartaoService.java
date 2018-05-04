package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Cartao;

public class CartaoService {

	private ArrayList <Cartao> cartoes = new ArrayList<Cartao>();
	
	public CartaoService()
	{

	}
	
	public void salvar(Cartao cartao)
	{
		//cartoes.add(cartao);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(cartao);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Cartao cartao)
	{
		//cartoes.remove(cartao);
		EntityManagerFactory emf;
		Campeonato campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Campeonato.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Cartao> getCartoes()
	{
		//return cartoes;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Cartao> carts;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Cartao> listaGenerica = (TypedQuery<Cartao>) em.createNativeQuery("select * from Cartao", Cartao.class);

		carts = (List<Cartao>) listaGenerica;

        em.close();
        emf.close();
        
		return carts;
	}

	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
}
