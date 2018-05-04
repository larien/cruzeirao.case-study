package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.PartidaFutebol;

public class PartidaFutebolService {

	private ArrayList <PartidaFutebol> partidasFutebol = new ArrayList<PartidaFutebol>();
	
	public PartidaFutebolService()
	{

	}
	
	public void salvar(PartidaFutebol partidaFutebol)
	{
		//partidasFutebol.add(partidaFutebol);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(partidaFutebol);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(PartidaFutebol partidaFutebol)
	{
		partidasFutebol.remove(partidaFutebol);
		EntityManagerFactory emf;
		PartidaFutebol campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(PartidaFutebol.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <PartidaFutebol> getPartidasFutebol()
	{
		//return partidasFutebol;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<PartidaFutebol> partsFuts;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<PartidaFutebol> listaGenerica = (TypedQuery<PartidaFutebol>) em.createNativeQuery("select * from PartidaFutebol", PartidaFutebol.class);

		partsFuts = (List<PartidaFutebol>) listaGenerica;

        em.close();
        emf.close();
        
		return partsFuts;
	}

	public void setPartidasFutebol(ArrayList<PartidaFutebol> partidasFutebol) {
		this.partidasFutebol = partidasFutebol;
	}
	
}
