package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;

public class CampeonatoService {

	private ArrayList <Campeonato> campeonatos = new ArrayList<Campeonato>();
	
	public CampeonatoService()
	{
		
	}

	public void salvar(Campeonato campeonato)
	{
		//campeonatos.add(campeonato);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(campeonato);
        em.close();
        em.getTransaction().commit();
		
	}

	public void remove(Campeonato campeonato)
	{
		//campeonatos.remove(campeonato);
		EntityManagerFactory emf;
		Campeonato campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

			campe = em.find(Campeonato.class, campeonato.getId());
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Campeonato> getCampeonatos()
	{
		//return campeonatos;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Campeonato> camps;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Campeonato> listaGenerica = (TypedQuery<Campeonato>) em.createNativeQuery("select * from Campeonato", Campeonato.class);

		camps = (List<Campeonato>) listaGenerica;

        em.close();
        emf.close();
        
		return camps;
	}

}
