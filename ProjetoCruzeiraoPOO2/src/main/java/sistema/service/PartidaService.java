package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Partida;

public class PartidaService {

	private List <Partida> partidas = new ArrayList<Partida>();
	
	public PartidaService()
	{

	}
	
	public void salvar(Partida partida)
	{
//		partidas.add(partida);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(partida);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Partida partida)
	{
		partidas.remove(partida);
		EntityManagerFactory emf;
		Partida campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Partida.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Partida> getPartidas()
	{
		//return partidas;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Partida> parts;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Partida> listaGenerica = (TypedQuery<Partida>) em.createNativeQuery("select * from Partida", Partida.class);

		parts = (List<Partida>) listaGenerica;

        em.close();
        emf.close();
        
		return parts;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

}
