package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Juiz;

public class JuizService {

	private List <Juiz> juizes = new ArrayList<Juiz>();
	
	public JuizService()
	{

	}
	
	public void salvar(Juiz juiz)
	{
		//juizes.add(juiz);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(juiz);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Juiz juiz)
	{
		juizes.remove(juiz);
		EntityManagerFactory emf;
		Juiz campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Juiz.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Juiz> getJuizes()
	{
		//return juizes;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Juiz> locs;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Juiz> listaGenerica = (TypedQuery<Juiz>) em.createNativeQuery("select * from Juiz", Juiz.class);

		locs = (List<Juiz>) listaGenerica;

        em.close();
        emf.close();
        
		return locs;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
		
	}
	
}
