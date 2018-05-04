package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Local;

public class LocalService {

	private ArrayList <Local> locais = new ArrayList<Local>();
	
	public LocalService()
	{

	}
	
	public void salvar(Local local)
	{
		//locais.add(local);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(local);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Local local)
	{
		locais.remove(local);
		EntityManagerFactory emf;
		Local campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Local.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Local> getLocais()
	{
		//return locais;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Local> locs;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Local> listaGenerica = (TypedQuery<Local>) em.createNativeQuery("select * from Local", Local.class);

		locs = (List<Local>) listaGenerica;

        em.close();
        emf.close();
        
		return locs;
	}
	
}
