package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Inscricao;

public class InscricaoService {

	private List <Inscricao> inscricoes = new ArrayList<Inscricao>();
	
	public InscricaoService()
	{

	}
	
	public void salvar(Inscricao inscricao)
	{
		//inscricoes.add(inscricao);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(inscricao);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Inscricao inscricao)
	{
		inscricoes.remove(inscricao);
		EntityManagerFactory emf;
		Inscricao campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Inscricao.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Inscricao> getInscricoes()
	{
		//return inscricoes;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Inscricao> inscrics;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Inscricao> listaGenerica = (TypedQuery<Inscricao>) em.createNativeQuery("select * from Inscricao", Inscricao.class);

		inscrics = (List<Inscricao>) listaGenerica;

        em.close();
        emf.close();
        
		return inscrics;
	}

	public void setInscricoes(List<Inscricao> list) {
		this.inscricoes = list;
	}
	
	
}
