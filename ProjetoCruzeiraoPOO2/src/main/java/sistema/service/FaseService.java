package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Fase;

public class FaseService {

	private List <Fase> fases = new ArrayList<Fase>();
	
	public FaseService()
	{

	}
	
	public void salvar(Fase fase)
	{
		//fases.add(fase);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(fase);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Fase fase)
	{
		fases.remove(fase);
		EntityManagerFactory emf;
		Fase campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Fase.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Fase> getFases()
	{
		//return fases;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Fase> fases;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Fase> listaGenerica = (TypedQuery<Fase>) em.createNativeQuery("select * from Fase", Fase.class);

		fases = (List<Fase>) listaGenerica;

        em.close();
        emf.close();
        
		return fases;
	}

	public void setFases(List<Fase> list) {
		this.fases = list;
	}
	
}
