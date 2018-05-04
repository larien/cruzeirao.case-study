package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;

public class UsuarioService {

	private ArrayList <Usuario> Usuarios = new ArrayList<Usuario>();
	
	public UsuarioService()
	{

	}
	
	public void salvar(Usuario Usuario)
	{
		//Usuarios.add(Usuario);
		/*
		 * Trecho de codigo implementado para salvar no banco
		 * */
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("BancoReservaCreate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	        em.persist(Usuario);
        em.close();
        em.getTransaction().commit();
	}

	public void remove(Usuario Usuario)
	{
		Usuarios.remove(Usuario);
		EntityManagerFactory emf;
		Usuario campe;
		emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			//id
			campe = em.find(Usuario.class, 1);
	        em.remove(campe);
        em.close();
        em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> getUsuarios()
	{
		//return Usuarios;

		/*
		 * Trecho de codigo implementado para buscar informacoes do banco
		 * */
		List<Usuario> usurs;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoReservaNone");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Usuario> listaGenerica = (TypedQuery<Usuario>) em.createNativeQuery("select * from Usuario", Usuario.class);

		usurs = (List<Usuario>) listaGenerica;

        em.close();
        emf.close();
        
		return usurs;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	
}
