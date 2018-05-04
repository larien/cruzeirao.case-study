package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Equipe;

public class EquipeService {

	private ArrayList <Equipe> equipes = new ArrayList<Equipe>();
	
	public EquipeService()
	{

	}
	
	public void salvar(Equipe equipe)
	{
		//equipes.add(equipe);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(equipe);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Equipe equipe)
	{
		equipes.remove(equipe);
		EntityManagerFactory emf;
		Equipe campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Equipe.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Equipe> getEquipes()
	{
		//return equipes;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Equipe> equips;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Equipe> listaGenerica = (TypedQuery<Equipe>) em.createNativeQuery("select * from Equipe", Equipe.class);

		equips = (List<Equipe>) listaGenerica;

        em.close();
        emf.close();
        
		return equips;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
