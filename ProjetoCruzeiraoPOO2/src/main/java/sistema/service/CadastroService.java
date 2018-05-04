package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;

public class CadastroService {

	private ArrayList <Usuario> cadastros = new ArrayList<Usuario>();
	
	public CadastroService()
	{
		
	}
	
	public void salvar(Usuario cadastro)
	{
		//cadastros.add(cadastro);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(cadastro);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Usuario cadastro)
	{
		//cadastros.remove(cadastro);
		EntityManagerFactory emf;
		Usuario campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Falta colocar ID
			campe = em.find(Usuario.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> getCadastros()
	{
		//return cadastros;
		
		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Usuario> cads;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Usuario> listaGenerica = (TypedQuery<Usuario>) em.createNativeQuery("select * from Cadastro", Usuario.class);

		cads = (List<Usuario>) listaGenerica;

        em.close();
        emf.close();
        
		return cads;
		
	}
	
}
