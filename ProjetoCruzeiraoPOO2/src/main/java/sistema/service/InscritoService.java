package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Inscrito;

public class InscritoService {

	private List <Inscrito> inscritos = new ArrayList<Inscrito>();
	
	public InscritoService()
	{

	}
	
	public void salvar(Inscrito inscrito)
	{
		//inscritos.add(inscrito);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(inscrito);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Inscrito inscrito)
	{
		inscritos.remove(inscrito);
		EntityManagerFactory emf;
		Inscrito campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Inscrito.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Inscrito> getInscritos()
	{
		//return inscritos;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Inscrito> inscrits;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Inscrito> listaGenerica = (TypedQuery<Inscrito>) em.createNativeQuery("select * from Inscrito", Inscrito.class);

		inscrits = (List<Inscrito>) listaGenerica;

        em.close();
        emf.close();
        
		return inscrits;
	}

	public void setInscritos(List<Inscrito> list) {
		this.inscritos = list;
	}
	
}
