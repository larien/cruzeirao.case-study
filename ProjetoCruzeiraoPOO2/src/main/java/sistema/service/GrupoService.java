package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Grupo;

public class GrupoService {

	private List <Grupo> grupos = new ArrayList<Grupo>();
	
	public GrupoService()
	{

	}
	
	public void salvar(Grupo grupo)
	{
		//grupos.add(grupo);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(grupo);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Grupo grupo)
	{
		grupos.remove(grupo);
		EntityManagerFactory emf;
		Grupo campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Grupo.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Grupo> getGrupos()
	{
		//return grupos;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Grupo> grups;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Grupo> listaGenerica = (TypedQuery<Grupo>) em.createNativeQuery("select * from Grupo", Grupo.class);

		grups = (List<Grupo>) listaGenerica;

        em.close();
        emf.close();
        
		return grups;
	}

	public void setGrupos(List<Grupo> list) {
		this.grupos = list;
	}
	
}
