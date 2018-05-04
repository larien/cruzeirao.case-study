package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Gol;

public class GolService {

	private ArrayList <Gol> gols = new ArrayList<Gol>();
	
	public GolService()
	{

	}
	
	public void salvar(Gol gol)
	{
		//gols.add(gol);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(gol);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Gol gol)
	{
		gols.remove(gol);
		EntityManagerFactory emf;
		Gol campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Gol.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Gol> getGols()
	{
		//return gols;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Gol> gols;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Gol> listaGenerica = (TypedQuery<Gol>) em.createNativeQuery("select * from Gol", Gol.class);

		gols = (List<Gol>) listaGenerica;

        em.close();
        emf.close();
        
		return gols;
	}
	
}
