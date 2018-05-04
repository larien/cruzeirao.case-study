package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Rodada;

public class RodadaService {

	private List <Rodada> rodadas = new ArrayList<Rodada>();
	
	public RodadaService()
	{

	}
	
	public void salvar(Rodada rodada)
	{
		//rodadas.add(rodada);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(rodada);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Rodada rodada)
	{
		rodadas.remove(rodada);
		EntityManagerFactory emf;
		Rodada campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Rodada.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Rodada> getRodadas()
	{
		//return rodadas;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Rodada> rods;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Rodada> listaGenerica = (TypedQuery<Rodada>) em.createNativeQuery("select * from Rodada", Rodada.class);

		rods = (List<Rodada>) listaGenerica;

        em.close();
        emf.close();
        
		return rods;
	}

	public void setRodadas(List<Rodada> list) {
		this.rodadas = list;
	}
	
}
