package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;

public class CategoriaService {

	private List <Categoria> categorias = new ArrayList<Categoria>();
	
	public CategoriaService()
	{

	}
	
	public void salvar(Categoria categoria)
	{
		//categorias.add(categoria);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(categoria);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Categoria categoria)
	{
		categorias.remove(categoria);
		EntityManagerFactory emf;
		Categoria campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Categoria.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Categoria> getCategorias()
	{
		//return categorias;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Categoria> categs;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Categoria> listaGenerica = (TypedQuery<Categoria>) em.createNativeQuery("select * from Categoria", Categoria.class);

		categs = (List<Categoria>) listaGenerica;

        em.close();
        emf.close();
        
		return categs;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
